<template>
	<div class="overtime">
		<el-row style="text-align: center;font-size: 26px;">
			<el-col>加班审批</el-col>
		</el-row>

		
		

		

		


		<el-row style="margin-top: 12px;">
			<el-col :span="5">

			</el-col>
			<el-col :span="5">

			</el-col>
			<el-col :span="6">

			</el-col>
			<el-col style="text-align: right;" :span="5">
			
				<el-button @click="dialogFormVisible=true">加班审批</el-button>
				
			</el-col>
		</el-row>
<el-dialog title="流程审批" v-model="dialogFormVisible">
		<el-form :model="flow" ref="flow" :rules="flow">
			<el-form-item label="流程名：" label-width="120px">
				<span>{{flow.approve_flow.flowName}}</span>
			</el-form-item>
			<el-form-item label="当前节点:" label-width="120px">
				<span>{{flow.spList[flow.spList.length-1].workflowNode.alinkey.alinkeyName}}</span>
			</el-form-item>
			<el-form-item label="是否通过" label-width="120px" prop="ispass">
				<el-radio-group v-model="flow.approveState">
					<el-radio :label=true>通过</el-radio>
					<el-radio :label=false>不通过</el-radio>
				</el-radio-group>
			</el-form-item>
			<el-form-item label="审批意见" label-width="120px">
				<el-input v-model="opinion" type="textarea" :rows="4">
				</el-input>
			</el-form-item>
			
				<template v-if=" index!=1 && flow.approveState==true &&
				 this.flow.spList[this.flow.spList.length-1].workflowNode.alinkey.alinkeyName !='董事长审批' ">
					<el-form-item  label="下个节点" label-width="120px">
						<el-cascader v-model="spadmin" :options="options" :props="{ checkStrictly: false }" clearable />
					</el-form-item>
				</template>
				
			
				
			
			
		</el-form>
		<template #footer>
			<span class="dialog-footer">
				<el-button @click="dialogFormVisible = false">取 消</el-button>
				<el-button type="primary" @click="subapprove()">确 定</el-button>
			</span>
		</template>
	</el-dialog>
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
				index:'',
				row:'',
				d:'',
				boos:false,
				flag:true,
				node: {},
				flow: {},
				flowsp: {},
				spadmin: '', //下一个审核人
				opinion: '', //意见
				options: [], //审批人
				dialogFormVisible: false,
				
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
				flowsId: "",
				explain: ""
			}
		},
		methods: {
			insertOver() {
				
				this.axios.post("overtime/insertOvertime", {
					spr: this.spadmin[1],
					boos:false,
					flow:this.flow,
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
			
			subapprove(){
				
				if(this.spadmin[1] != undefined){
					this.spadmin=this.spadmin[1];
				}else{
					this.spadmin=0;
				}
				let prim = {
					id:this.flow.spList[this.flow.spList.length-1].flowSpId ,
					state:this.flow.approveState, 
					row:this.opinion,
					spr:this.spadmin,
					appd:this.flow.approveId,
					flowSpId:this.flow.workflowNode.nodeId,
					flow:this.flow.approve_flow.flowId,
					node:this.flow.workflowNode.nodeId
				};
				
				console.log(prim);
				let qsprim = qs.stringify(prim);
				
				this.axios.post("sp/update", qsprim).then(res => {
					if (res.code == 1) {
						ElMessage.success({
							message: '审批成功！',
							type: 'success'
						});
						this.dialogFormVisible=false;
						
						this.$router.replace("/flowmonitoring");
					}
					})
			},
			
			sax(val){
				let prim = {
					id: val
				};
				let qsprim = qs.stringify(prim);
				this.axios.post("node/selectid", qsprim).then(res => {
					if (res.code == 1) {
						
							if(this.node==res.data[res.data.length-1].nodeId){
								this.index=1;
							}
						
					}
				})
			},
			//查询该申请的记录
			SelectHistory(val){
				
				let prim = {
					id: val
				};
				console.log(val,"dddddddd");
				let qsprim = qs.stringify(prim);
				this.axios.post("approve/selectid", qsprim).then(res => {
						
					if (res.code == 1) {
						this.flow=res.obj;
						console.log(this.flow,"dwadawdaw");
						if(this.flow.spList[this.flow.spList.length-1].flowSpState!=null && 
						this.flow.spList[this.flow.spList.length-1].workflowNode.alinkey.alinkeyId==2){
							this.boos=true;
						} 
						
						
						
						this.node=this.flow.workflowNode.nodeId;
						this.selectsp(res.obj.approve_flow.flowId);
					}
				
				})
			},
			// 根据职位查询审批人
			selectposition(val) {
				
				let prim = {
					id: val
				};
			
				let qsprim = qs.stringify(prim);
				this.axios.post("sp/grade", qsprim).then(res => {
					
					console.log(prim,"返回值是啥");
					if (res.code == 1) {
						let good = {
							value: res.data[res.data.length-1].systemPost.postName,
							label: res.data[res.data.length-1].systemPost.postName,
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
			
				})
			},selectsp(val) {
				let prim = {
					id: val
				};
			
				let qsprim = qs.stringify(prim);
				this.axios.post("node/selectpo", qsprim).then(res => {
					let x=0;
					if (res.code == 1) {
						this.flowsp=res.data.length;
						if (res.data.length > 0) {
							
							res.data.forEach((r,index)=>{
									
								if(this.$route.params.node==r.nodeId){
										this.selectposition(res.data[index+1].nodeLast);
									
									 
								}
							})
							
							
						}
			
					}
			
				})
			},
		},
		mounted() {
			
			
			
			if(this.$route.params.table){
				let prim = {
					id: this.$route.params.table
				};
				let qsprim = qs.stringify(prim);
				this.axios.post("overtime/selectid", qsprim).then(res => {
					if (res.code == 1) {
						this.row=res.obj;
					}
				
				})
				
			}
			this.SelectHistory(this.$route.params.table);
			this.sax(this.$route.params.approveId);
		}
	}
</script>

<style>
	.overtime {
		width: 98%;
		margin: 0 auto;
	}
</style>
