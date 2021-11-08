<template>
	<div class="reimbu">
		<el-row style="text-align: center;font-size: 28px;">
			<el-col>报销申请</el-col>
		</el-row>

		<el-row style="margin-top: 12px;">
			<el-col style="text-align: right;line-height: 32px;" :span="3">
				报销人：
			</el-col>
			<el-col :span="4">
				<el-input type="text" v-model="emp.empName" disabled size="small"></el-input>
			</el-col>
			<el-col style="text-align: right;line-height: 32px;" :span="3">
				部门：
			</el-col>
			<el-col :span="4">
				<el-input type="text" v-model="dept.departmentName" disabled size="small"></el-input>
			</el-col>
			<el-col style="text-align: right;line-height: 32px;" :span="3">
				职位：
			</el-col>
			<el-col :span="4">
				<el-input type="text" v-model="post.postName" disabled size="small"></el-input>
			</el-col>
		</el-row>

		<el-row style="margin-top: 12px;">
			<!-- <el-col style="text-align: right;line-height: 32px;" :span="3">
				审批流程：
			</el-col>
			<el-col :span="4">
				<el-select v-model="flowsId" placeholder="审批流程">
					<el-option v-for="item in flows" :key="item.value" :label="item.label" :value="item.value">
					</el-option>
				</el-select>
			</el-col> -->
			<el-col style="text-align: right;line-height: 32px;" :span="3">
				出差单：
			</el-col>
			<el-col :span="4">
				<el-select v-model="busId" placeholder="出差单名称">
					<el-option v-for="item in bus" :key="item.businessId" :label="item.businessName"
						:value="item.businessId">
					</el-option>
				</el-select>
			</el-col>
			<el-col style="text-align: right;line-height: 32px;" :span="3">
				报销总金额：
			</el-col>
			<el-col :span="4">
				<el-input type="text" v-model="zje" size="small"></el-input>
			</el-col>
		</el-row>


		<el-row style="margin-top: 12px;">
			<el-col>新增具体的报销详情</el-col>
		</el-row>
		<el-row style="margin-top: 6px;">
			<el-col style="text-align: right;line-height: 32px;" :span="3">
				报销名称：
			</el-col>
			<el-col :span="4">
				<el-input type="text" size="small" v-model="bxname"></el-input>
			</el-col>

			<el-col style="text-align: right;line-height: 32px;" :span="3">
				报销金额：
			</el-col>
			<el-col :span="4">
				<el-input type="text" size="small" v-model.number="bxje"></el-input>
			</el-col>
			<el-col :span="1"></el-col>
			<el-col :span="2">
				<el-button type="primary" size="mini" @click="baocun">保存</el-button>
			</el-col>
		</el-row>

		<!-- {{xq}} -->
		<el-row style="margin-top: 12px;">
			<el-col>
				<el-table :data="xq" style="width: 100%">
					<el-table-column align="center" label="报销名称">
						<template #default="scope">
							<span style="margin-left: 10px">{{ scope.row.name }}</span>
						</template>
					</el-table-column>
					<el-table-column align="center" label="报销金额">
						<template #default="scope">
							<span style="margin-left: 10px">{{ scope.row.je }}</span>
						</template>
					</el-table-column>
				</el-table>
			</el-col>
		</el-row>

		<el-row style="margin-top: 12px;">
			<el-col style="text-align: right;" :span="2">
				<el-button type="primary" size="mini" round @click="insertRei">提交</el-button>
			</el-col>
			<el-col :span="2">
				<el-button type="primary" size="mini" round @click="qx">取消</el-button>
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
				userName: "层旭",
				/* dept: {
					deptId: 7,
					deptName: "人事部"
				}, */
				/* post: {
					postId: 1,
					postName: "员工"
				}, */
				options: [{
						value: '1',
						label: '审批人',
					},
					{
						value: '2',
						label: 'Option2',
					}
				],
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
				explain: "",
				emp: [],
				dept: [],
				post: [],
				akes: [],
				bus: [], //出差单
				busId: "",
				bxje: "",
				bxname: "",
				xq: [],
				zje: ""
			}
		},
		methods: {
			baocun() {
				let s = {
					name: this.bxname,
					je: this.bxje
				}
				let money = 0;
				this.xq.push(s)
				this.xq.forEach(r => {
					money += r.je
				});
				this.zje = money
				this.bxje = ""
				this.bxname = ""
			},
			reimburse() {
				this.dept = this.$store.state.users.department;
				this.emp = this.$store.state.users.archivesEmp;
				this.post = this.$store.state.users.post;
				console.log(this.emp)
				this.axios.get("reimburse/selectByReId", {
					params: {
						empId: this.emp.empid
					}
				}).then(res => {
					console.log(res)
					this.bus = res
				});
			},
			qx() {
				this.$router.push({
					name: "reimbures"
				})
			},
			insertRei() {
				let f = {
					empId: this.emp.empId,
					deptId: this.dept.departmentId,
					flowId: this.busId,
					postId: this.post.postId,
					zje: this.zje,
					xq: this.xq,
				}
				console.log(f, "=-")
				this.axios.post("reimburse/insertRei", f).then(res => {
					console.log(res)
					/*if (res > 0) {
						ElMessage({
							message: "申请成功",
							type: 'success'
						});
						this.$router.push({
							name: "clockinginleave"
						})
					} else {
						ElNotification({
							title: 'Error',
							message: '申请失败',
							type: 'error',
						})
					} */
				});
			}
		},
		mounted() {
			this.reimburse();
		}
	}
</script>

<style scoped>
	.reimbu {
		width: 98%;
		margin: 0 auto;
	}
</style>
