<template>

	<el-row class="JNPF-common-search-box" :gutter="16">
		<el-form @submit.native.prevent>
			<el-col :span="12">
				<el-form-item label="流程标题">
					<el-input v-model="query.name" placeholder="请输入" clearable> </el-input>
				</el-form-item>
			</el-col>

			<el-col :span="12">
				<el-form-item>
					<el-button type="primary" @click="search()">查询</el-button>
				</el-form-item>
			</el-col>
			<el-col :span="12">
				<el-form-item>
					<el-button type="primary" @click="dialogVisible=true">创建流程</el-button>
				</el-form-item>
			</el-col>



		</el-form>
	</el-row>
	<el-table :data="list" style="width: 100%">
		<el-table-column label="编号" width="180">
			<template #default="scope">

				<span style="margin-left: 10px">{{ scope.row.flowId }}</span>
			</template>
		</el-table-column>
		<el-table-column label="流程名称" width="180">
			<template #default="scope">

				<span style="margin-left: 10px">{{ scope.row.flowName }}</span>
			</template>
		</el-table-column>
		<el-table-column label="web地址" width="180">
			<template #default="scope">

				<span style="margin-left: 10px">{{ scope.row.flowUrl }}</span>
			</template>
		</el-table-column>
		<el-table-column label="创建时间" width="180">
			<template #default="scope">

				<span style="margin-left: 10px">{{ scope.row.flowTime }}</span>
			</template>
		</el-table-column>
		<el-table-column label="状态" width="180">
			<template #default="scope">

				<span style="margin-left: 10px">
				   <el-switch
					  @click="OpenState(scope.$index, scope.row)"
				      v-model="scope.row.flowState"
				      inline-prompt
				      active-color="#13ce66"
				      inactive-color="#ff4949"
				      active-text="Y"
				      inactive-text="N"
				    />
				
				</span>
			</template>
		</el-table-column>

		<el-table-column label="操作">
			<template #default="scope">
				<el-button size="mini" @click="handleEdit(scope.$index, scope.row)">Edit</el-button>
				<el-button size="mini" type="danger" @click="handleDelete(scope.$index, scope.row)">Delete</el-button>
			</template>
		</el-table-column>
	</el-table>

	<div class="demo-pagination-block">

		<el-pagination @size-change="handleSizeChange" @current-change="handleCurrentChange"
			:current-page="currentPage4"
			:page-sizes="[5,10]"
			:page-size="pagesize"
			layout="total, sizes, prev, pager, next, jumper" 
			:total="total">
		</el-pagination>
	</div>

	<el-dialog v-model="dialogVisible" title="创建流程" width="60%">
		<el-form ref="form" :model="form" label-width="120px">
			<el-form-item label="流程名称">
				<el-input v-model="flow.name"></el-input>
			</el-form-item>
			<el-form-item label="流程类型">
				<el-select v-model="OptionsType" placeholder="请选择类型">

					<template v-for="item in option">
						<el-option :label="item.alinkeyName" :value="item.alinkeyId"></el-option>
					</template>
				</el-select>


			</el-form-item>
			<el-form-item label="发起职位 ">
				<el-select v-model="OptionsPosition" placeholder="请选择职位">
					<template v-for="item in OptionP">
						<el-option :label="item.name" :value="item.id"></el-option>
					</template>
				</el-select>
			</el-form-item>
			<el-form-item label="审批节点">
				<el-checkbox-group class="checkbox-group" flex="wrap:wrap"  v-model="handleArr">
					<el-checkbox v-for="(item, index) in tableData" :disabled="item.disabled" @change="handleCheckedCitiesChange(item)" :label="item" :key="index" border>
						{{ item.alinkeyName}}
					</el-checkbox>
				</el-checkbox-group>
			</el-form-item>
			<el-form-item label="已选节点">
				<template v-for="item in handleArr">
					<span style="margin-right: 10px;">
						{{item.alinkeyName}}
					</span>
				</template>

			</el-form-item>


			<el-form-item label="Web地址">
				<el-input v-model="flow.adds"></el-input>
			</el-form-item>
			<el-form-item label="是否启用">
				<el-switch v-model="flow.state" active-color="#13ce66" inactive-color="#ff4949" />
			</el-form-item>
			<el-form-item>
				<el-button type="primary" @click="onSubmit">Create</el-button>
				<el-button @click="dialogVisible=false">Cancel</el-button>
			</el-form-item>
		</el-form>
	</el-dialog>
	
	<el-dialog v-model="dialogVisibleUpdate" title="修改流程" width="60%">
		<el-form ref="form" label-width="120px">
			<el-form-item label="流程名称">
				<el-input v-model="flows.flowName"></el-input>
			</el-form-item>
			<el-form-item label="流程类型">
				<el-select v-model="flowstype" placeholder="请选择类型">
	
					<template v-for="item in option">
						<el-option :label="item.alinkeyName" :value="item.alinkeyId"></el-option>
					</template>
				</el-select>
	
	
			</el-form-item>
			<el-form-item label="发起职位 ">
				<el-select v-model="OptionsPosition" placeholder="请选择职位">
					<template v-for="item in OptionP">
						<el-option :label="item.name" :value="item.id"></el-option>
					</template>
				</el-select>
			</el-form-item>
			<el-form-item label="审批节点">
				<el-checkbox-group class="checkbox-group" flex="wrap:wrap"   v-model="handleArr">
					<el-checkbox v-for="(item, index) in tableData"  
					:label="item" :key="index" border  :disabled="item.disabled" @change="handleCheckedCitiesChange(item)" >
						{{ item.alinkeyName}}
					</el-checkbox>
				</el-checkbox-group>
			</el-form-item>
			<el-form-item label="已选节点">
				
				<template v-for="item in handleArrUpdate">
					<span style="margin-right: 10px;">
						{{item.alinkeyName}}
					</span>
				</template>
	
			</el-form-item>
	
	
			<el-form-item label="Web地址">
				<el-input v-model="flows.flowUrl"></el-input>
			</el-form-item>
			<el-form-item label="是否启用">
				<el-switch v-model="flows.flowState" active-color="#13ce66" inactive-color="#ff4949" />
			</el-form-item>
			<el-form-item>
				<el-button type="primary" @click="offSubmit">Create</el-button>
				<el-button @click="dialogVisibleUpdate=false">Cancel</el-button>
			</el-form-item>
		</el-form>
	</el-dialog>
	
</template>

<script lang="ts">
	import qs from 'qs'
	import {
		ElMessage
	} from 'element-plus'
	export default {
		data() {
			return {
				handleArrUpdate:[],
				flowstype:'',
				flows:{},
				OptionP: [{
					id: 1,
					name: '普通员工',
					type:1
				}, {
					id: 2,
					name: '部门主管',
					type:2
				}, {
					id: 3,
					name: '总经理',
					type:3
				}
				
				],
				
				option: [],
				tableData: [],
				list: [],
				dialogVisibleUpdate:false,
				dialogVisible: false,
				OptionsPosition: 1,
				OptionsType: [],
				query: {},
				checked: [],
				pageno: 1,
				pagesize: 5,
				total: 0,
				flow: {
					name: '',
					adds: '',
					state: true,
				},
				handleArr: [], // 选中的数组

			}
		},
		methods: {
			handleCheckedCitiesChange(value){
				
	
				if(this.handleArr.length>1){
					var end = this.handleArr[this.handleArr.length-2];
					
						if(end.alinkeyId>value.alinkeyId){
							ElMessage.error({
								message: '不符合规范！'
							});
							this.handleArr=[];
						}
					
				}
				
				
				
			},
			offSubmit(){
				let prim = {
					id:this.flows.flowId,
					name: this.flows.flowName,
					type:this.flowstype,
					position:this.flowstype,
					jieduan:this.handleArrUpdate,
					web:this.flows.flowUrl,
					state:this.flows.flowState
				};
				this.axios.post("flow/update", prim).then(res => {
					if(res.code==1){
						ElMessage.success({
							message: '修改流程完成！',
							type: 'success'
						});
						this.dialogVisibleUpdate=false;
						this.selectall();
					}else{
						this.selectall();
					}
				
				
				});
			},
			
			OpenState(index, row){
				let prim={
										id:row.flowId
									};
									let qsprim=qs.stringify(prim);
				this.axios.post("flow/updatezt", qsprim).then(res => {
					if(res.code==1){
						ElMessage.success({
							message: '修改完成！',
							type: 'success'
						});
						this.selectall();
					}else{
						this.selectall();
					}
						
				})
			},
			
			 handleEdit(index, row) {
			      this.dialogVisibleUpdate=true;
				  
				  let prim={
				  						id:row.flowId
				  					};
				  					let qsprim=qs.stringify(prim);
				  this.axios.post("flow/select", qsprim).then(res => {
				  	if(res.code==1){
				  		this.flows=res.obj;
						this.flowstype=this.flows.alinkey.alinkeyId;
						
						this.axios.post("node/selectid", qsprim).then(reh => {
							if(res.code==1){
								reh.data.forEach(ress=>{
									this.handleArrUpdate.push(ress.alinkey);
									
								})
												
							}
						 })
				  	}
				  })
			    },
			    handleDelete(index, row) {
					let prim={
						id:row.flowId
					};
					console.log(prim);
					let qsprim=qs.stringify(prim);
			      this.axios.post("flow/delect", qsprim).then(res => {
			      	if(res.code==1){
			      		ElMessage.success({
			      			message: '流程删除完成！',
			      			type: 'success'
			      		});
			      		this.selectall();
			      	}
			      		
			      })
			    },
			
			search() {
				this.selectall();
			},
			handleSizeChange(val) {
				this.pagesize = val;
				this.selectall();
			},
			handleCurrentChange(val) {
				this.pageno = val;
				this.selectall();
			},
			onSubmit() {
				
				let prim = {
					id:0,
					name: this.flow.name,
					type:this.OptionsType,
					position:this.OptionsPosition,
					jieduan:this.handleArr,
					web:this.flow.adds,
					state:this.flow.state
				};
				
				
				this.axios.post("flow/add",prim).then(res => {
					if(res.code==1){
						prim.id=res.obj;
			
							ElMessage.success({
								message: '流程创建完成！',
								type: 'success'
							});
							
							this.dialogVisible=false;
							this.selectall();
						
						}
							this.flow.name='';
							this.OptionsType='';
							this.OptionsPosition=1;
							this.handleArr=[];
							this.flow.adds='';
					})
					
				
			},
			SelectType(ids) {
				//查询类别
				let prim = {
					id: ids
				};
				let qsprim = qs.stringify(prim);
				this.axios.post("type/select", qsprim).then(res => {
					this.option = res.data;
				})
			},
			SelectTypeJd(ids) {
				//查询类别
				let PrimJD = {
					id: ids
				};
				let QsPrim = qs.stringify(PrimJD);
				this.axios.post("type/select", QsPrim).then(res => {
					this.tableData = res.data;
				})
			},
			//查询所有流程 
			selectall() {

				let PrimName = {
					no: this.pageno,
					size: this.pagesize,
					name: this.query.name
				};
				
				this.axios.post("flow/all", PrimName).then(res => {
					this.list = res.obj.list;;
					this.total = res.obj.total;
					this.pageno = res.obj.pageNum;
					this.pagesize = res.obj.pageSize;
				})
			}
			
		},
		created() {
			this.SelectType(1);
			this.SelectTypeJd(5);
			this.selectall();
		},watch:{
		
			handleArr(){
				
				
				if(this.dialogVisibleUpdate==true){
					this.handleArrUpdate=[];
					this.handleArr.forEach(res=>{
						this.handleArrUpdate.push(res);
					})
				}
				
				
				
			},dialogVisible(){
				if(this.dialogVisibleUpdate==false){
					this.handleArr=[];
					this.handleArrUpdate=[];
				}
			},OptionsPosition(){
				this.handleArr=[];
				this.OptionP.forEach(res=>{
					if(this.OptionsPosition==res.id){
						
						if(res.type==2){
							this.tableData.forEach(rel=>{
							if(rel.alinkeyId==6){
									rel.disabled=true;
								}
							})
							
						}
						
						if(res.type==3){
							this.tableData.forEach(rel=>{
							if(rel.alinkeyId==7 || rel.alinkeyId==6){
									rel.disabled=true;
								}
							})
							
							
						}
						if(res.type==1){
							this.tableData.forEach(rel=>{
									rel.disabled=false;
							})
							
						}
						
					}
				})
				
			}
		}
	}
</script>
