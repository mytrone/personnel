<template>
	<div class="leaveOne">
		<el-row>
			<el-col>
				<el-button type="primary" size="mini" round @click="addLeave">新增</el-button>
			</el-col>
		</el-row>
		<hr>

		<el-row style="margin-top: 18px;">
			<el-col>
				请假日期：<el-date-picker v-model="datastart" type="date" size="small" placeholder="选择开始时间">
				</el-date-picker> - <el-date-picker v-model="datafinish" size="small" type="date" placeholder="选择结束时间">
				</el-date-picker>
				<span style="margin-left: 12px;">
					<el-button size="small" type="primary " round @click="inquire">查询</el-button>
				</span>
			</el-col>
		</el-row>

		<el-row style="margin-top: 12px;text-align: center;font-size: 28px;">
			<el-col>
				请假申请记录
			</el-col>
		</el-row>

		<el-row style="margin-top: 18px;">
			<el-col>
				<el-table :data="leave" style="width: 100%">
					<el-table-column align="center" label="序号" type="index">
					</el-table-column>
					<el-table-column align="center" label="申请时间">
						<template #default="scope">
							<span>
								{{scope.row.leaveName}}
							</span>
						</template>
					</el-table-column>

					<el-table-column align="center" label="请假人">
						<template #default="scope">
							<span>
								{{scope.row.empId.empName}}
							</span>
						</template>
					</el-table-column>
					<el-table-column align="center" label="部门">
						<template #default="scope">
							<span>
								{{scope.row.departmentId.departmentName}}
							</span>
						</template>
					</el-table-column>
					<el-table-column align="center" label="职位">
						<template #default="scope">
							<span>
								{{scope.row.postId.postName}}
							</span>
						</template>
					</el-table-column>
					<el-table-column align="center" label="请假类型">
						<template #default="scope">
							<span>
								{{scope.row.alinkeyId.alinkeyName}}
							</span>
						</template>
					</el-table-column>
					<el-table-column align="center" label="开始时间">
						<template #default="scope">
							<span>
								{{scope.row.leaveStart}}
							</span>
						</template>
					</el-table-column>
					<el-table-column align="center" label="结束时间">
						<template #default="scope">
							<span>
								{{scope.row.leaveFinish}}
							</span>
						</template>
					</el-table-column>
					<el-table-column align="center" label="请假天数">
						<template #default="scope">
							<span>
								{{scope.row.leaveDays}}
							</span>
						</template>
					</el-table-column>
					<!-- <el-table-column align="center" label="流程状态">
						<template #default="scope">
							<span>
								{{scope.row}}
							</span>
						</template>
					</el-table-column> -->

					<!-- <el-table-column label="Operations">
						<template #default="scope">
							<el-button size="mini" @click="handleEdit(scope.$index, scope.row)">Edit</el-button>
							<el-button size="mini" type="danger" @click="handleDelete(scope.$index, scope.row)">Delete
							</el-button>
						</template>
					</el-table-column> -->
				</el-table>
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
				leave: [],
				pageNo: 1,
				pageSize: 5,
				total: 0,
				emp: [],
				dept: [],
				post: [],
				datastart: "",
				datafinish: ""
			}
		},
		methods: {
			inquire() {
				/* console.log(this.$store.state.users, "登录存储的信息")
				if (this.datastart != '') {
					this.datastart = moment(this.datastart).format("YYYY-MM-DD")
				}
				if (this.datafinish != '') {
					this.datafinish = moment(this.datafinish).format("YYYY-MM-DD")
				}
				this.axios.get("leave", {
					params: {
						pageNo: this.pageNo,
						pageSize: this.pageSize,
						empId: this.emp.empId,
						datastart: this.datastart,
						datafinish: this.datafinish
					}
				}).then(res => {
					console.log(res.obj)
					if (res.code === 1) {
						this.leave = res.obj.list;
						this.total = res.obj.total;
					}
				}); */
				/* this.axios.get("leave", {
					params: {
						empId: this.emp.empId,
						datastart: this.datastart,
						datafinish: this.datafinish
					}
				}).then(res => {

				}); */
				this.leaveSelect();
			},
			/* 新增按钮 */
			addLeave() {
				this.$router.push({
					name: "clockinginleavemadd"
				});
			},
			leaveSelect() {
				this.dept = this.$store.state.users.department
				this.emp = this.$store.state.users.archivesEmp
				this.post = this.$store.state.users.post
				console.log(this.$store.state.users, "登录存储的信息")
				this.axios.get("leave", {
					params: {
						pageNo: this.pageNo,
						pageSize: this.pageSize,
						empId: this.emp.empId,
						datastart: this.datastart,
						datafinish: this.datafinish
					}
				}).then(res => {
					console.log(res.obj)
					if (res.code === 1) {
						this.leave = res.obj.list;
						this.total = res.obj.total;
					}
				});
			}
		},
		mounted() {
			this.leaveSelect();
		}
	}
</script>

<style scoped>
	.leaveOne {
		width: 98%;
		margin: 0 auto;
	}
</style>
