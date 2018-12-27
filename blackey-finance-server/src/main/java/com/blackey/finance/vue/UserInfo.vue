<template>
    <div class="mod-userInfo">
        <el-form :inline="true" :model="dataForm" @keyup.enter.native="getDataList()">
            <el-form-item>
                <el-input v-model="dataForm.userName" placeholder="用户名" clearable></el-input>
            </el-form-item>
            <el-form-item>
                <el-button @click="getDataList()">查询</el-button>
                <el-button v-if="isAuth('finance:userInfo:save')" type="primary" @click="addOrUpdateHandle()">新增</el-button>
                <el-button v-if="isAuth('finance:userInfo:delete')" type="danger" @click="deleteHandle()" :disabled="dataListSelections.length <= 0">批量删除</el-button>
            </el-form-item>
        </el-form>
        <el-table
                :data="dataList"
                border
                v-loading="dataListLoading"
                @selection-change="selectionChangeHandle"
                style="width: 100%;">
            <el-table-column
                    type="selection"
                    header-align="center"
                    align="center"
                    width="50">
            </el-table-column>

                            <el-table-column
                        prop="telephone"
                        header-align="center"
                        align="center"
                        width="100"
                        label="手机号">
                </el-table-column>
                            <el-table-column
                        prop="email"
                        header-align="center"
                        align="center"
                        width="100"
                        label="邮箱">
                </el-table-column>
                            <el-table-column
                        prop="wechatNo"
                        header-align="center"
                        align="center"
                        width="100"
                        label="微信号">
                </el-table-column>
                            <el-table-column
                        prop="avatarUrl"
                        header-align="center"
                        align="center"
                        width="100"
                        label="微信头像">
                </el-table-column>
                            <el-table-column
                        prop="openId"
                        header-align="center"
                        align="center"
                        width="100"
                        label="openid">
                </el-table-column>
                            <el-table-column
                        prop="company"
                        header-align="center"
                        align="center"
                        width="100"
                        label="公司名称">
                </el-table-column>
                            <el-table-column
                        prop="duties"
                        header-align="center"
                        align="center"
                        width="100"
                        label="职位">
                </el-table-column>
                            <el-table-column
                        prop="companyBrief"
                        header-align="center"
                        align="center"
                        width="100"
                        label="公司简介">
                </el-table-column>
                            <el-table-column
                        prop="companyWebsite"
                        header-align="center"
                        align="center"
                        width="100"
                        label="公司官网">
                </el-table-column>
                            <el-table-column
                        prop="companyAddress"
                        header-align="center"
                        align="center"
                        width="100"
                        label="公司地址">
                </el-table-column>
                            <el-table-column
                        prop="visitingAcrd"
                        header-align="center"
                        align="center"
                        width="100"
                        label="名片图片地址">
                </el-table-column>
                            <el-table-column
                        prop="isIdentity"
                        header-align="center"
                        align="center"
                        width="100"
                        label="是否实名认证 ">
                </el-table-column>
            
                                                <el-table-column
                            fixed="right"
                            header-align="center"
                            align="center"
                            width="150"
                            label="操作">
                        <template slot-scope="scope">
                            <el-button v-if="isAuth('finance:userInfo:update')" type="text" size="small"
                                       @click="addOrUpdateHandle(scope.row.telephone)">修改</el-button>
                            <el-button v-if="isAuth('finance:userInfo:delete')" type="text" size="small"
                                       @click="deleteHandle(scope.row.telephone)">删除</el-button>
                        </template>
                    </el-table-column>
                                                                                                                                                                                                                                                                                                                                                
        </el-table>
        <el-pagination
                @size-change="sizeChangeHandle"
                @current-change="currentChangeHandle"
                :current-page="pageIndex"
                :page-sizes="[10, 20, 50, 100]"
                :page-size="pageSize"
                :total="totalPage"
                layout="total, sizes, prev, pager, next, jumper">
        </el-pagination>
        <!-- 弹窗, 新增 / 修改 -->
        <add-or-update v-if="addOrUpdateVisible" ref="addOrUpdate" @refreshDataList="getDataList"></add-or-update>
    </div>
</template>


<script>
    import AddOrUpdate from './userInfo-add-or-update'
    export default {
        data () {
            return {
                dataForm: {
                    userName: ''
                },
                dataList: [],
                pageIndex: 1,
                pageSize: 10,
                totalPage: 0,
                dataListLoading: false,
                dataListSelections: [],
                addOrUpdateVisible: false
            }
        },
        components: {
            AddOrUpdate
        },
        activated () {
            this.getDataList()
        },
        methods: {
            // 获取数据列表,params 需要手动添加
            getDataList () {
                this.dataListLoading = true
                this.$http({
                    url: this.$http.adornUrl("${moduleName}/${classname}/list"),
                    method: 'get',
                    params: this.$http.adornParams({


                    })
                }).then(({data}) => {
                    if (data && data.code === 200) {
                        this.dataList = data.data.list
                        this.totalPage = data.data.totalCount
                    } else {
                        this.dataList = []
                        this.totalPage = 0
                    }
                    this.dataListLoading = false
                })
            },
            // 每页数
            sizeChangeHandle (val) {
                this.pageSize = val
                this.pageIndex = 1
                this.getDataList()
            },
            // 当前页
            currentChangeHandle (val) {
                this.pageIndex = val
                this.getDataList()
            },
            // 多选
            selectionChangeHandle (val) {
                this.dataListSelections = val
            },
            // 新增 / 修改
            addOrUpdateHandle (id) {
                this.addOrUpdateVisible = true
                this.$nextTick(() => {
                    this.$refs.addOrUpdate.init(id)
                })
            },

                                    // 删除
                deleteHandle (id) {
                    var ids = id ? [id] : this.dataListSelections.map(item => {
                        return item.telephone
                    })
                    this.$confirm(`确定对[id=${ids.join(',')}]进行[${id} ? '删除' : '批量删除'}]操作?`, '提示', {
                        confirmButtonText: '确定',
                        cancelButtonText: '取消',
                        type: 'warning'
                    }).then(() => {
                        this.$http({
                            url: this.$http.adornUrl("${moduleName}/${classname}/delete"),
                            method: 'post',
                            data: this.$http.adornData(ids, false)
                        }).then(({data}) => {
                            if (data && data.code === 200) {
                                this.$message({
                                    message: '操作成功',
                                    type: 'success',
                                    duration: 1500,
                                    onClose: () => {
                                        this.getDataList()
                                    }
                                })
                            } else {
                                //需要添加 data.messge
                                this.$message.error()
                            }
                        })
                    }).catch(() => {})
                }
                                                                                                                                                                                                                                                
        }
    }
</script>

<style scoped>

</style>