<template>
    <el-table
      :data="tableData"
      style="width: 100%">
	  <el-table-column
	    prop="recruitapplyTitle"
	    label="申请标题"
	    width="180">
	  </el-table-column>
      <el-table-column
        prop="recruitapplyEducationInf"
        label="学历要求">
      </el-table-column>
	  <el-table-column
	    prop="recruitapplyPnum"
	    label="需求人数">
	  </el-table-column>
	  <el-table-column
	    prop="recruitapplyPosition"
	    label="申请岗位">
	  </el-table-column>
	  <el-table-column
	    prop="recruitapplyEason"
	    label="申请理由">
	  </el-table-column>
	  <el-table-column
	    prop="recruitapplyTime"
	    label="申请时间">
	  </el-table-column>
	  <el-table-column
	    prop="recruitapplyState"
	    label="申请状态">
	  </el-table-column>
	  <el-table-column label="操作">
		 <template #default="scope">
			<el-button>查看</el-button>
			<el-button v-show="scope.row.recruitapplyState==1" @click="jump()">发布招聘信息</el-button>
		 </template>
	  </el-table-column>
    </el-table>
  </template>

<script lang="ts">
import { Timer } from '@element-plus/icons'

export default {
  data() {
    return {
	  xinxi:{},
	  tableData:[],
    }
  },
  methods: {  
	jump(){
		this.$router.push({
		   name:"/Recruit_demand"
		})
	},
    selectAll(){
    	this.axios.post("recruitRecruitapply/selectRecruitapply").then(res=>{
    		this.tableData=res
    		console.log("tableData",this.tableData)
    	})
    }
  },created() {
	  this.selectAll()
  }
}
</script>

<style scoped="scoped">
	
</style>
  
  