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
		<el-table :data="departments.slice((currentPage-1)*pagesize,currentPage*pagesize)">
			<el-table-column prop="departmentId" label="部门编号"></el-table-column>
			<el-table-column prop="departmentName" label="部门名称"></el-table-column>
			<el-table-column label="操作">
				<template v-slot:default="v">
					<el-button size="mini" @click="changeDepartment(v.row)">修改</el-button>
					<el-button size="mini" @click="delDepartment(v.row.departmentId)">删除</el-button>
				</template>				
			</el-table-column>
		</el-table>
		<el-pagination @size-change="handleSizeChange" @current-change="handleCurrentChange" layout="total, sizes, prev, pager, next, jumper"
		 :page-size="pagesize" :page-sizes="[5, 10, 15]" :total="departments.length">
		</el-pagination>
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
				},
				//初始页
				currentPage: 1, 
				 //每页的数据
				pagesize: 5,
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
					this.departments=v
				})
			},
			//部门新增
			addDepartment(){
				if(this.systemDepartment.departmentName==''){
					this.$message({
					          message: '部门名称不得为空',
					          type: 'warning'
					});
				}else{
					if(this.systemDepartment.departmentId!=''){
						this.axios.post(
							'system/changeDepartment',
							this.systemDepartment
						).then((v)=>{
							this.restDepartment(),
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
							this.restDepartment(),
							this.selDepartment(),
							this.$message({
							  message: '部门新增成功',
							  type: 'success'
							});
						})
					}
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
					
					if(v=="yes"){
						this.selDepartment(),
						this.$message({
						  message: '部门删除成功',
						  type: 'success'
						});
					}else{
						this.$message({
						  message: '有员工存在，不得删除',
						  type: 'warning'
						});
					}
					
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
			},
			handleSizeChange: function(size) {
				this.pagesize = size;
			},
			handleCurrentChange: function(currentPage) {
				this.currentPage = currentPage;
			},
		},
		created(){
			this.selDepartment()
		}
	}
</script>

<style>
</style>
