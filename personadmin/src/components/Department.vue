<template>
	<el-row :gutter="16">
		<el-col :span="6"><el-input v-model="value"></el-input></el-col>
		<el-col :span="3">
			<el-button @click="selDepartment()">查询</el-button>			
		</el-col>
		<el-col :span="6"><el-input v-model="systemDepartment.departmentName"></el-input></el-col>
		<el-col :span="6">
			<el-button @click="addDepartment()">保存</el-button>	
			<el-button @click="restDepartment()">重置</el-button>	
		</el-col>
	</el-row>
	<el-row :gutter="10">
		<el-col :span="16">
			<el-table :data="departments">
				<el-table-column prop="departmentId" label="部门编号"></el-table-column>
				<el-table-column prop="departmentName" label="部门名称"></el-table-column>
				<el-table-column label="操作">
					<template v-slot:default="v">
						<el-button size="mini" @click="changeDepartment(v.row)">修改</el-button>
						<el-button size="mini" @click="delDepartment(v.row.departmentId)">删除</el-button>
					</template>				
				</el-table-column>
			</el-table>
		</el-col>		
	</el-row>
</template>

<script>
	export default{
		data(){
			return{
				//接受后台查到的部门
				departments:[],
				//绑定部门搜索框
				value:'',
				//传到后台的部门对象
				systemDepartment:{
					departmentId:'',
					departmentName:''
				}
			}
		},
		methods:{
			//查询部门
			selDepartment(){
				this.axios({
					url:'system/selDepartment',
					params:{
						departmentName:this.value
					}
				}).then((v)=>{
					this.departments=v.data
				})
			},
			//部门新增
			addDepartment(){
				if(this.systemDepartment.departmentId!=''){
					this.axios.post(
						'system/changeDepartment',
						this.systemDepartment
					).then((v)=>{
						this.selDepartment(),
						this.$message({
						  message: '部门修改成功',
						  type: 'success'
						});
					})
				}else{
					this.axios.post(
						'system/addDepartment',
						this.systemDepartment
					).then((v)=>{
						this.selDepartment(),
						this.$message({
						  message: '部门新增成功',
						  type: 'success'
						});
					})
				}
				
			},
			//部门删除
			delDepartment(val){
				this.axios({
					url:'system/delDepartment',
					params:{
						departmentId:val
					}
				}).then((v)=>{
					this.selDepartment(),
					this.$message({
					  message: '部门删除成功',
					  type: 'success'
					});
				})				
			},
			//部门修改
			changeDepartment(val){
				this.systemDepartment.departmentId=val.departmentId,
				this.systemDepartment.departmentName=val.departmentName
			},
			//重置部门对象
			restDepartment(){
				this.systemDepartment={
					departmentId:'',
					departmentName:''
				}
			}
		},
		created(){
			this.selDepartment()
		}
	}
</script>

<style>
</style>
