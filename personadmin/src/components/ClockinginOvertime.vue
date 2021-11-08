<template>
	<div class="divOne">
		<!-- {{overtime}} -->
		<el-row style="margin-top: 8px;">
			<el-col :span="4">
				<el-button type="primary" size="mini" round @click="addOvertime">新增</el-button>
			</el-col>
		</el-row>
		<hr />
		<el-row style="margin-top: 18px;">
			<el-col>
				加班日期：<el-date-picker v-model="datastart" type="date" size="small" placeholder="选择开始时间">
				</el-date-picker> - <el-date-picker v-model="datafinish" size="small" type="date" placeholder="选择结束时间">
				</el-date-picker>
				<span style="margin-left: 12px;">
					<el-button size="small" type="primary " round @click="inquire">查询</el-button>
				</span>
			</el-col>
		</el-row>

		<el-row style="margin-top: 18px;">
			<el-col>
				<el-table :data="overtime" style="width: 100%">
					<el-table-column align="center" type="index" label="序号">
					</el-table-column>
					<el-table-column align="center" label="加班申请">
						<template #default="scope">
							<span style="margin-left: 10px">{{ scope.row.alinkeyByAlinkeyId.alinkeyName }}</span>
						</template>
					</el-table-column>
					<el-table-column align="center" label="加班人">
						<template #default="scope">
							<span style="margin-left: 10px">{{ scope.row.archivesEmpByEmpId.empName }}</span>
						</template>
					</el-table-column>
					<el-table-column align="center" label="开始时间">
						<template #default="scope">
							<span style="margin-left: 10px">{{ scope.row.overtimeStart }}</span>
						</template>
					</el-table-column>
					<el-table-column align="center" label="结束时间">
						<template #default="scope">
							<span style="margin-left: 10px">{{ scope.row.overtimeFinish }}</span>
						</template>
					</el-table-column>

					<el-table-column align="center" label="加班时长">
						<template #default="scope">
							<span style="margin-left: 10px">{{ scope.row.overtimeDuration }}</span>
						</template>
					</el-table-column>
					<el-table-column align="center" label="备注">
						<template #default="scope">
							<span style="margin-left: 10px">{{ scope.row.overtimeReason }}</span>
						</template>
					</el-table-column>
				</el-table>
			</el-col>
		</el-row>

		<el-row style="margin-top: 12px;">
			<el-col>
				<el-pagination v-model:currentPage="currentPage4" :page-sizes="[5, 15, 20, 40]" :page-size="pageSize"
					layout="total, sizes, prev, pager, next, jumper" :total="total" @size-change="handleSizeChange"
					@current-change="handleCurrentChange">
				</el-pagination>
			</el-col>
		</el-row>

	</div>
</template>

<script>
	import moment from 'moment'
	import {
		ElMessageBox,
		ElMessage
	} from 'element-plus'
	import qs from 'qs'

	export default {
		data() {
			return {
				overtime: [],
				pageNo: 1,
				pageSize: 5,
				total: 0,
				datastart: "",
				datafinish: ""
			};
		},
		/* computed: {
			dates(iter){
				console.log(iter.frequency[0].punchCard,"时间");
				let v=moment(iter.frequency[0].punchCard).format("HH:mm:ss")
				console.log(v)
				return v;
			}
		}, */
		methods: {

			handleSizeChange(val) {
				console.log(`每页 ${val} 条`,val);
				this.pageSize=val
				this.overtimeAll();
			},
			handleCurrentChange(val) {
				console.log(`当前页: ${val}`);
				this.pageNo=val
				this.overtimeAll();
			},
			/* 查询 */
			inquire() {
				console.log(moment(this.datastart).format("YYYY-MM-DD"), "=", moment(this.datafinish).format("YYYY-MM-DD"))
				this.overtimeAll();
			},
			overtimeAll() {
				if (this.datastart != '') {
					this.datastart = moment(this.datastart).format("YYYY-MM-DD")
				}
				if (this.datafinish != '') {
					this.datafinish = moment(this.datafinish).format("YYYY-MM-DD")
				}
				this.axios.get("overtime", {
					params: {
						pageNo: this.pageNo,
						pageSize: this.pageSize,
						empId: 1,
						start: this.datastart,
						finsh: this.datafinish
					}
				}).then(res => {
					this.total = res.obj.total
					console.log(res.obj.list)
					this.overtime = res.obj.list
				});
			},
			/* 新增 */
			addOvertime() {
				this.$router.push({
					name: "clockinginovertimeadd"
				})
			}
		},
		mounted() {
			this.overtimeAll();
		}
	}
</script>

<style scoped>
	.divOne {
		width: 98%;
		margin: 0 auto;
	}
</style>
