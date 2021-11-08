<template>
	<div class="overtime">
		<el-row style="text-align: center;font-size: 26px;">
			<el-col>加班申请</el-col>
		</el-row>

		<el-row style="margin-top: 18px;">
			<el-col>
				基本信息
			</el-col>
		</el-row>
		<el-row style="margin-top: 12px;">
			<el-col style="text-align: right;line-height: 32px;" :span="3">
				申请人：
			</el-col>
			<el-col :span="4">
				<el-input type="text" v-model="userName" disabled size="small"></el-input>
			</el-col>
			<el-col style="text-align: right;line-height: 32px;" :span="3">
				申请部门：
			</el-col>
			<el-col :span="4">
				<el-input type="text" v-model="dept.deptName" disabled size="small"></el-input>
			</el-col>
			<el-col style="text-align: right;line-height: 32px;" :span="3">
				申请职位：
			</el-col>
			<el-col :span="4">
				<el-input type="text" v-model="post.postName" disabled size="small"></el-input>
			</el-col>
		</el-row>

		<el-row style="margin-top: 12px;">
			<el-col style="text-align: right;line-height: 32px;" :span="3">
				开始时间：
			</el-col>
			<el-col :span="4">
				<el-date-picker v-model="statr" type="datetime" placeholder="开始时间">
				</el-date-picker>
			</el-col>
			<el-col style="text-align: right;line-height: 32px;" :span="3">
				结束时间：
			</el-col>
			<el-col :span="4">
				<el-date-picker v-model="finsh" type="datetime" placeholder="结束时间">
				</el-date-picker>
			</el-col>
			<el-col style="text-align: right;line-height: 32px;" :span="3">
				加班时长：
			</el-col>
			<el-col :span="4">
				<el-input type="text" v-model="duration" size="small"></el-input>
			</el-col>
		</el-row>
<template  v-if="d!=3" >
		<el-row style="margin-top: 12px;">
			<el-col style="text-align: right;line-height: 32px;" :span="3">
				审批人：
			</el-col>
			<el-col :span="4">
				<el-cascader v-model="spadmin" :options="options" :props="{ checkStrictly: false }" clearable />
			</el-col>
			
			
			<el-col style="text-align: right;line-height: 32px;" :span="3">

			</el-col>
			<el-col :span="4">

			</el-col>
		</el-row>
</template>
		<el-row style="margin-top: 12px;">
			<el-col style="text-align: right;line-height: 32px;" :span="3">
				说明：
			</el-col>
			<el-col :span="18">
				<el-input v-model="explain" :autosize="{ minRows: 4}" type="textarea" placeholder="说明">
				</el-input>
			</el-col>
		</el-row>


		<el-row style="margin-top: 12px;">
			<el-col :span="5">

			</el-col>
			<el-col :span="5">

			</el-col>
			<el-col :span="6">

			</el-col>
			<el-col style="text-align: right;" :span="5">
				<template v-if="d!=3">
					<el-button type="primary" size="mini" round @click="insertOver">保存</el-button>
				</template>
				
			</el-col>
		</el-row>

	</div>
</template>

<script>
	import moment from 'moment'
	import {
		ElMessageBox,
		ElNotification,
		ElMessage
	} from 'element-plus'
	import qs from 'qs'

	export default {
		data() {
			return {
				row:'',
				d:'',
				options: [],
				spadmin:'',
				boos:false,
				flowsId: "",
				
				userName: "层旭",
				dept: {
					deptId: 7,
					deptName: "人事部"
				},
				post: {
					postId: 1,
					postName: "员工"
				},
				statr: "",
				finsh: "",
				duration: "",
				
				value: '',
				flows: [{
						value: '58',
						label: 'Option1',
					},
					{
						value: '59',
						label: 'Option2',
					}
				],
				
				explain: ""
			}
		},
		methods: {
			insertOver() {
				
				this.axios.post("overtime/insertOvertime", {
					spr: this.spadmin[1],
					boos:false,
					
					// 
					empId: 1,
					deptId: this.dept.deptId,
					
					typeName: "加班申请",
					flowId: this.flowsId,
					postId: this.post.postId,
					start: this.statr,
					finish: this.finsh,
					reason: this.duration,
					explain: this.explain
				}).then(res => {
					console.log(res)
					if (res > 0) {
						ElMessage({
							message: "申请成功",
							type: 'success'
						});
						this.$router.push({
							name: "clockinginovertime"
						})
					} else {
						ElNotification({
							title: 'Error',
							message: '申请失败',
							type: 'error',
						})
					}
				});
			}, 
			
			
			
			
			/// 根据职位查询审批人
			selectposition(val) {
				
				let prim = {
					id: val
				};

				let qsprim = qs.stringify(prim);
				this.axios.post("sp/grade", qsprim).then(res => {
					
					
					if (res.code == 1) {
						if(res.data.length>0){
						let good = {
							value: res.data[0].systemPost.postName,
							label: res.data[0].systemPost.postName,
							children: []
						};
						res.data.forEach(item => {
							let goods = {
								value: item.empId,
								label: item.empName,
							}
							good.children.push(goods);
						})
						this.options.push(good);
					}
					}

				})
			},
			//查询流程可以审批的职位
			selectsp(val0) {
				let prim = {
					id: val0
				};
				
				let qsprim = qs.stringify(prim);
				this.axios.post("node/selectpo", qsprim).then(res => {
					
					if (res.code == 1) {
						
						if (res.data.length > 0) {
							
							this.selectposition(res.data[0].nodeLast);
							this.flowsId=res.data[0].workflowFlow.flowId;

						}

					}

				})
			},

			selectnode(val1,url) {
				//查询职位层级
				let prim = {
					id: val1
				};
				let qsprim = qs.stringify(prim);
				this.axios.post("system/select", qsprim).then(res => {
					if (res.code == 1) {
						
						
						this.position = res.obj;
						console.log("这里返回的",res.obj);
						this.selectUrl(url);
					}

				})
			},
			selectUrl(val2) {
				//查询当前页面的流程
				let prims = {
					url: val2
				};
				
				
				let qsprims = qs.stringify(prims);
				this.axios.post("flow/selecturl", qsprims).then(res => {
					if (res.code == 1) {
							let op=false;
						res.obj.forEach(re => {
							
							if(re.flowPosition == this.d){
								
							if (re.flowPosition == this.position.postGrade &&
								re.flowState == true ) {
									op=true;
								this.selectsp(re.flowId); //选择当前流程使用
							}
							}
						})
						
						if(op==false){
							if(this.d!=3){
								ElMessage.error({
									message: '没有你当前职位流程！！！'
								});
							}
							
							
						} 
						
					}

				})
			}

		},
		mounted() {
			this.d = 0; //当前职位 层级 //当前用户职位 0普通员工 1主管 2总经理 3董事长
			if (this.d == 0) {
				this.selectnode(1, this.$route.path); //当前用户职位 0普通员工 1主管 2总经理 3董事长
			}
			if (this.d == 1) {
				this.selectnode(2, this.$route.path); //当前用户职位 0普通员工 1主管 2总经理 3董事长
			}
			if (this.d == 2) {
				this.selectnode(3, this.$route.path); //当前用户职位 0普通员工 1主管 2总经理 3董事长
			}
			
			
			
			

		}
	}
</script>

<style>
	.overtime {
		width: 98%;
		margin: 0 auto;
	}
</style>
