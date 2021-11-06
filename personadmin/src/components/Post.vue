<template>
	<el-row :gutter="16">
		<el-col :span="6"><el-input v-model="value"></el-input></el-col>
		<el-col :span="3">
			<el-button @click="selPost()">查询</el-button>			
		</el-col>
		
	</el-row>
	<el-row :gutter="10">
		<el-col :span="16">
			<el-table :data="posts">
				<el-table-column prop="post_id" label="职位编号"></el-table-column>
				<el-table-column prop="departmentName" label="职位名称"></el-table-column>
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
				posts:[],
				//绑定部门搜索框
				value:''
			}
		},
		methods:{
			//查询部门
			selPost(){
				this.axios({
					url:'system/selPost'
				}).then((v)=>{
					this.posts=v.data
					console.log(this.posts)
				})
			}			
		},
		created(){
			this.selPost()
		}
	}
</script>

<style>
</style>
