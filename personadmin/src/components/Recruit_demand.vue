<template>
    <el-table
      :data="tableData"
      style="width: 100%">
	  <el-table-column
	    prop="interviewrecordName"
	    label="面试人"
	    width="180">
	  </el-table-column>
	  <el-table-column
	    prop="interviewrecordNumber"
	    label="面试得分">
	  </el-table-column>
	  <el-table-column label="操作">
		 <template #default="scope">
			<el-button @click="this.centerDialogVisible=true,open()">发送offer</el-button><br>
		 </template>
	  </el-table-column>
    </el-table>
	
  </template>
	
<script lang="ts">
import { Timer } from '@element-plus/icons'

export default {
  data() {
    return {
	  tableData:[],
	  
    }
  },
  methods: {
	  open() {
	          this.$message('已成功发送');
	        },
    selectAll(){
    	this.axios.post("recruitinterviewrecord/selectInterviewrecord").then(res=>{
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
  
  