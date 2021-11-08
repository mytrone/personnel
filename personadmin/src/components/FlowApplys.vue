<template>
	
	<el-button @click="dialogFormVisible=true">审批</el-button>
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
			<el-form-item v-if="flowsp>1" label="下个节点" label-width="120px">
				<el-cascader v-model="spadmin" :options="options" :props="{ checkStrictly: false }" clearable />
			</el-form-item>
		</el-form>
		<template #footer>
			<span class="dialog-footer">
				<el-button @click="dialogFormVisible = false">取 消</el-button>
				<el-button type="primary" @click="subapprove()">确 定</el-button>
			</span>
		</template>
	</el-dialog>
	
</template>

<script lang="ts">
	import {
		ElMessage
	} from 'element-plus'
	import qs from 'qs'
	export default {

		data() {
			return {
				
				
				node: {},
				flow: {},
				flowsp: {},
				spadmin: '', //下一个审核人
				opinion: '', //意见
				options: [], //审批人
				dialogFormVisible: false
			}
		},
		methods: {
			subapprove(){
				let prim = {
					id:this.flow.workflowNode.nodeId ,
					state:this.flow.approveState, 
					row:this.opinion,
					spr:this.spadmin[1],
					appd:this.flow.approveId
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
					}
					})
			},
			
			//查询该申请的记录
			SelectHistory(val){
				let prim = {
					id: val
				};
				
				let qsprim = qs.stringify(prim);
				this.axios.post("approve/selectid", qsprim).then(res => {
						console.log("返回处理的结果",res);
					if (res.code == 1) {
						this.flow=res.obj;
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
					if (res.code == 1) {
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
			
				})
			},selectsp(val) {
				let prim = {
					id: val
				};

				let qsprim = qs.stringify(prim);
				this.axios.post("node/selectpo", qsprim).then(res => {

					if (res.code == 1) {
						this.flowsp=res.data.length;
						if (res.data.length > 0) {
							res.data.forEach(rr=>{
								if(rr.nodeId==this.node){
									
								}else{
									this.selectposition(rr.nodeLast);
									return false;
								}
								
							})
							
						}

					}

				})
			},


		},
		created() {
		this.SelectHistory(10);
		
		}
	}
</script>
