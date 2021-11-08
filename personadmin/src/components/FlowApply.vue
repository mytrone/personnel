<template>
	<el-cascader v-model="spadmin" :options="options" :props="{ checkStrictly: false }" clearable />



</template>

<script lang="ts">
	import {
		ElMessage
	} from 'element-plus'
	import qs from 'qs'
	export default {

		data() {
			return {
				d:'',
				position: {},
				flow: {},
				flowsp: {},
				spadmin: '', //下一个审核人
				opinion: '', //意见
				options: [], //审批人
				dialogFormVisible: false
			}
		},
		methods: {
			// 根据职位查询审批人
			selectposition(val) {
				
				let prim = {
					id: val
				};

				let qsprim = qs.stringify(prim);
				this.axios.post("sp/grade", qsprim).then(res => {
					console.log(res,"vvvvvvv");
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
						console.log("这里返回啥万一",res);
						if (res.data.length > 0) {
							
							this.selectposition(res.data[0].nodeLast);

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
						console.log(res.obj,"fffff");
						
						this.position = res.obj;
						this.selectUrl(url);
					}

				})
			},
			selectUrl(val2) {
				//查询当前页面的流程
				let prims = {
					url: val2
				};
				console.log(val2,"duahduwah");
				console.log(prims);
				let qsprims = qs.stringify(prims);
				this.axios.post("flow/selecturl", qsprims).then(res => {
					if (res.code == 1) {
							
						res.obj.forEach(re => {
							
							if(re.flowPosition == this.d){
								console.log(re.flowPosition );
								console.log(this.position,"dadaw");
							if (re.flowPosition == this.position.postGrade &&
								re.flowState == true ) {
									console.log("进了这里吗");
									
								this.selectsp(re.flowId); //选择当前流程使用
							} else {
								ElMessage.error({
									message: '没有你当前职位流程！！！'
								});
								// this.$router.replace("/flowdesign");
							}
							}
						})
					}

				})
			}


		},
		created() {
					 this.d=0;//当前职位编号  //当前用户职位 0普通员工 1主管 2总经理 3董事长
					if(this.d==0){
						this.selectnode(1,this.$route.path); //当前用户职位 0普通员工 1主管 2总经理 3董事长
					}
					if(this.d==1){
						this.selectnode(2,this.$route.path); //当前用户职位 0普通员工 1主管 2总经理 3董事长
					}
					if(this.d==2){
						this.selectnode(3,this.$route.path); //当前用户职位 0普通员工 1主管 2总经理 3董事长
					}
					
			
					
		}
	}
</script>
