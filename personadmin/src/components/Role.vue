<template>
	<el-row :gutter="16">
		<el-form>
			<el-col :span="10">
				<el-form-item label="角色名">
					<el-input v-model="value"></el-input>
				</el-form-item>
			</el-col>
			<el-col :span="11">
				<el-button @click="selRole()">查询</el-button>
				<el-button @click="dialogVisible=true">角色新增</el-button>
			</el-col>
		</el-form>		
	</el-row>
	<el-table :data="roles.slice((currentPage-1)*pagesize,currentPage*pagesize)">
		<el-table-column prop="roleId" label="编号"></el-table-column>
		<el-table-column prop="roleName" label="角色名"></el-table-column>
		<el-table-column prop="roleText" label="角色描述"></el-table-column>
		<el-table-column label="操作">
			<template v-slot:default="v">
				<el-button size="mini" @click="selRoleAuthority(v.row)">修改</el-button>
				<el-button size="mini" @click="delRole(v.row.roleId)">删除</el-button>
			</template>	
		</el-table-column>
	</el-table>
	<el-pagination @size-change="handleSizeChange" @current-change="handleCurrentChange" layout="total, sizes, prev, pager, next, jumper"
	 :page-size="pagesize" :page-sizes="[5, 10, 15]" :total="roles.length">
	</el-pagination>
	
	<el-dialog v-model="dialogVisible" title="角色新增">
		<el-form ref="role" :model="role" :rules="roleRules" label-width="70px">	
			<el-row :gutter="20">
				<el-col :span="10">
					<el-form-item prop="roleName" label="角色名">
						<el-input v-model="role.roleName"></el-input>
					</el-form-item>
					<el-form-item label="备注">
						<el-input  type="textarea" :rows="4" v-model="role.roleText"></el-input>
					</el-form-item>
					<el-form-item>
						<el-button @click="addRole('role')">保存</el-button>
						<el-button @click="restRole">取消</el-button>
					</el-form-item>
				</el-col>
				<el-col :span="10">
					<el-tree
					  :data="authoritys"
					  show-checkbox
					  default-expand-all
					  node-key="authorityId"
					  ref="tree"
					  highlight-current	  
					  :props="defaultProps">
					</el-tree>
				</el-col>
			</el-row>
		</el-form>	
	</el-dialog>
</template>

<script>
	export default{
		data(){
			return{
				//接收后台传来的权限组
				authoritys:[],
				//接收后台传来的角色
				roles:[],
				//显示的子集
				defaultProps: {
				  children: 'authorityChilds',
				  label:'authorityName'
				},
				//绑定搜索框
				value:'',
				//传到后台的角色对象
				role:{
					roleId:'',
					roleName:'',
					roleText:''
				},
				//角色初始页
				currentPage: 1, 
				 //角色每页的数据
				pagesize: 5,
				//控制弹框
				dialogVisible:false,
				//表单校验
				roleRules:{
					roleName:[{
						required: true,
						message: "角色名不得为空",
						trigger: "blur"
					}]
				}
			}
		},
		methods:{
			//查看权限
			selAuthority(){
				this.axios({
					url:'system/selAuthority'
				}).then((v)=>{
					this.authoritys=v
				})
			},
			//确认新增角色
			addRole(val){
				//获得勾选的节点
				var funs = this.$refs.tree.getCheckedKeys();
				this.$refs[val].validate(valid => {
					if(valid){
						if(this.role.roleId==''){
							//走新增
							this.axios.post(
								'system/addRole',{
									systemRole:this.role,
									funs:funs
								}
							).then((v)=>{
								this.selRole(),
								this.restRole(),
								this.$message({
								  message: '新增成功',
								  type: 'success'
								});
							})
						}else{
							//走修改
							this.axios.post(
								'system/changeRole',{
									systemRole:this.role,
									funs:funs
								}
							).then((v)=>{
								this.selRole(),
								this.restRole(),
								this.$message({
								  message: '修改成功',
								  type: 'success'
								});
							})
						}
					}
				})				
			},
			//查看角色
			selRole(){
				this.axios({
					url:'system/selRole',
					params:{
						roleName:this.value,
					}
				}).then((v)=>{
					this.roles=v
				})
			},
			//删除角色
			delRole(val){
				this.axios({
					url:'system/delRole',
					params:{
						roleId:val
					}
				}).then((v)=>{
					if(v=="yes"){
						this.selRole(),
						this.$message({
						  message: '角色删除成功',
						  type: 'success'
						});
					}else{
						this.$message({
						  message: '角色正被使用中',
						  type: 'warning'
						});
					}
					
				})
			},
			//查看角色的权限
			selRoleAuthority(val){
				this.role.roleId=val.roleId,
				this.role.roleName=val.roleName,
				this.role.roleText=val.roleText,
				this.axios({
					url:'system/selRoleAuthority',
					params:{
						roleId:val.roleId
					}
				}).then((v)=>{
					 this.$nextTick(function() {
						this.$refs.tree.setCheckedKeys(v)
					})
					 this.dialogVisible=true
				})
			},
			//重置表单
			restRole(){
				this.role={
					roleId:'',
					roleName:'',
					roleText:''
				},
				this.$refs.tree.setCheckedKeys([]),
				this.dialogVisible=false
			},
			handleSizeChange: function(size) {
				this.pagesize = size;
			},
			handleCurrentChange: function(currentPage) {
				this.currentPage = currentPage;
			},
			/* //获取
			selAuthorityByStaffId(){
				this.axios({
					url:'system/selAuthorityByStaffId',
					params:{
						staffId:1
					}
				}).then((v)=>{
					console.log("哈哈")
					//console.log(v)
				})
			} */
		},
		created(){
			this.selAuthority()
			this.selRole()
			//this.selAuthorityByStaffId()
		}
	}
</script>

<style>
</style>
