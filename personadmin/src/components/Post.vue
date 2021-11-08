<template>
	<el-row :gutter="16">
		<el-form>
			<el-col :span="13">
				<el-form-item label="所属部门">
					<el-select v-model="value">
						<el-option v-for="item in departments" :label="item.departmentName" :value="item.departmentId"></el-option>
						<el-option label="所有" :value="''"></el-option>
					</el-select>
				</el-form-item>
			</el-col>
			<el-col :span="11">
				<el-button @click="selPost()">查询</el-button>
				<el-button @click="dialogVisible=true">新增</el-button>
			</el-col>
		</el-form>
	</el-row>
	<el-row :gutter="10">		
		<el-table :data="posts.slice((currentPage-1)*pagesize,currentPage*pagesize)">
			<el-table-column prop="postId" label="序号"></el-table-column>
			<el-table-column prop="postName" label="职位名称"></el-table-column>
			<el-table-column prop="systemDepartment.departmentName" label="所属部门"></el-table-column>
			<el-table-column prop="postFather.postName" label="上级职位">
				<template v-slot:default="v">
					{{v.row.postFather==null?"无":v.row.postFather.postName}}
				</template>
			</el-table-column>
			<el-table-column label="操作">
				<template v-slot:default="v">
					<el-button size="mini" @click="changePost(v.row)">修改</el-button>
					<el-button size="mini" @click="delPost(v.row.postId)">删除</el-button>
				</template>				
			</el-table-column>
		</el-table>
		<el-pagination @size-change="handleSizeChange" @current-change="handleCurrentChange" layout="total, sizes, prev, pager, next, jumper"
		 :page-size="pagesize" :page-sizes="[5, 10, 15]" :total="posts.length">
		</el-pagination>
	</el-row>
	<el-dialog v-model="dialogVisible">
		<el-form ref="post" :model="post" :rules="postRules">
			<el-form-item label="职位名称" prop="postName">
				<el-input v-model="post.postName"></el-input>
			</el-form-item>
			<el-form-item label="所属部门" prop="departmentId">
				<el-select v-model="post.departmentId" @change="selPostByDepartment(post.departmentId)">
					<el-option v-for="item in departments" :label="item.departmentName" :value="item.departmentId"></el-option>
				</el-select>
			</el-form-item>
			<el-form-item label="职位等级" prop="postGrade">
				<el-select v-model="post.postGrade">
					<el-option label="高级" :value=3></el-option>
					<el-option label="中级" :value=2></el-option>
					<el-option label="初级" :value=1></el-option>
				</el-select> 
			</el-form-item>
			<el-form-item label="上级职位" prop="postParentId">
			<el-select v-model="post.postParentId">
				<el-option label="无" :value="0"></el-option>
				<el-option v-for="item in posts2" :label="item.postName" :value="item.postId"></el-option>
			</el-select>
			</el-form-item>
			<el-form-item>
				<el-button @click="addPost('post')">确认</el-button>
				<el-button @click="">取消</el-button>
			</el-form-item>
		</el-form>
	</el-dialog>
</template>

<script>
	export default{
		data(){
			return{
				//接受后台查到的职位
				posts:[],
				//根据部门查询职位
				posts2:[],
				//接受后台查到的部门
				departments:[],
				//绑定部门搜索框
				value:'',
				//职位初始页
				currentPage: 1, 
				 //职位每页的数据
				pagesize: 5,
				//传到后台的职位对象
				post:{
					postId:'',
					postName:'',
					postParentId:'',
					postGrade:'',
					departmentId:''
				},
				//控制弹框的打开
				dialogVisible:false,
				//表单校验规则
				postRules:{
					postName:[{
						required: true,
						message: "请输入职位名称",
						trigger: "blur"
					}],
					postParentId:[{
						required: true,
						message: "请选择上级职位",
						trigger: "blur"
					}],
					postGrade:[{
						required: true,
						message: "请选择职位等级",
						trigger: "blur"
					}],
					departmentId:[{
						required: true,
						message: "请选择所属部门",
						trigger: "blur"
					}]
				}
			}
		},
		methods:{
			//查询部门
			selDepartment(){
				this.axios({
					url:'system/selDepartment'
				}).then((v)=>{
					this.departments=v
				})
			},
			//根据部门查询职位
			selPostByDepartment(val){
				this.axios({
					url:'system/selPost',
					params:{
						param:val
					}
				}).then((v)=>{
					this.posts2=v,
					console.log(this.posts2)
				})
			},
			//查询职位
			selPost(){
				this.axios({
					url:'system/selPost',
					params:{
						param:this.value
					}
				}).then((v)=>{
					this.posts=v
				})
			},
			//职位新增
			addPost(val){
				this.$refs[val].validate(valid => {
					if(valid){
						if(this.post.postId==''){
							this.axios.post(
								'system/addPost',this.post
							).then((v)=>{
								this.selPost(),
								this.dialogVisible=false,
								this.$message({
								  message: '职位新增成功',
								  type: 'success'
								});
							})
						}else{
							this.axios.post(
								'system/changePost',this.post
							).then((v)=>{
								this.selPost(),
								this.dialogVisible=false,
								this.$message({
								  message: '职位修改成功',
								  type: 'success'
								});
							})
						}						
					}
				})				
			},
			//职位删除
			delPost(val){
				this.axios({
					url:'system/delPost',
					params:{
						postId:val
					}
				}).then((v)=>{
					this.selPost(),
					this.$message({
					  message: '部门删除成功',
					  type: 'success'
					});
				})
			},
			//职位修改
			changePost(val){
				this.post.postId=val.postId
				this.post.postName=val.postName,
				this.post.postParentId=val.postParentId,
				this.selPostByDepartment(val.departmentId),
				this.post.postGrade=val.postGrade,
				this.post.departmentId=val.departmentId,
				this.dialogVisible=true
			},
			handleSizeChange: function(size) {
				this.pagesize = size;
			},
			handleCurrentChange: function(currentPage) {
				this.currentPage = currentPage;
			},
		},
		created(){
			this.selDepartment(),
			this.selPost(),			
			//console.log(JSON.parse(sessionStorage.getItem("users")))
			console.log(this.$store.state.users)
		}
	}
</script>

<style>
</style>
