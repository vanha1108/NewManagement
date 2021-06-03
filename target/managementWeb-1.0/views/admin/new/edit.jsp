<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/common/taglib.jsp" %>
<c:url var="APIurl" value="/api-admin-new"/>
<c:url var="Newurl" value="/admin-new"/>
<html>
<head>
    <title>Chỉnh sửa bài viết</title>
</head>
<body>
<div class="main-content">
    <div class="main-content-inner">
        <div class="breadcrumbs" id="breadcrumbs">
            <script type="text/javascript">
                try {
                    ace.settings.check('breadcrumbs', 'fixed')
                } catch (e) {
                }
            </script>
            <ul class="breadcrumb">
                <li>
                    <i class="ace-icon fa fa-home home-icon"></i>
                    <a href="#">Trang chủ</a>
                </li>
                <li class="active">Chỉnh sửa bài viết</li>
            </ul><!-- /.breadcrumb -->
        </div>
        <div class="page-content">
            <div class="row">
                <div class="col-xs-12">
                    <form id="formSubmit">
                        <c:if test="${not empty messageParam}">
                            <div class="alert alert-${alert}">
                                    ${messageParam}
                            </div>
                        </c:if>
                        <div class="form-group">
                            <label class="col-sm-3 control-label no-padding-right">Thể loại</label>
                            <div class="col-sm-9">
                                <select class="form-control" id="categoryId" name="categoryId">
                                    <c:if test="${empty model.categoryId}">
                                        <option value="">Chọn loại bài viết</option>
                                        <c:forEach var="item" items="${categories}">
                                            <option value="${item.id}">${item.name}</option>
                                        </c:forEach>
                                    </c:if>

                                    <c:if test="${not empty model.categoryId}">
                                        <option value="">Chọn loại bài viết</option>
                                        <c:forEach var="item" items="${categories}">
                                            <option value="${item.id}"
                                                    <c:if test="${item.id == model.categoryId}">selected="selected"</c:if> >${item.name}</option>
                                        </c:forEach>
                                    </c:if>
                                </select>
                            </div>
                        </div>
                        <br/>
                        <br/>
                        <div class="form-group">
                            <label class="col-sm-3 control-label no-padding-right">Tiêu đề</label>
                            <div class="col-sm-9">
                                <input type="text" class="form-control" id="title" name="title" value="${model.title}"/>
                            </div>
                        </div>
                        <br/>
                        <br/>


<%--                        <div class="form-group">--%>
<%--                            <label class="col-sm-3 control-label no-padding-right">Hình đại diện</label>--%>
<%--                            <div class="col-sm-9">--%>
<%--                                <input type="text" class="form-control" id="thumbnail" name="thumbnail"--%>
<%--                                       value="${model.thumbnail}"/>--%>
<%--                            </div>--%>
<%--                        </div>--%>

                        <div class="form-group">
                            <label class="col-sm-3 control-label no-padding-right">Hình bài viết</label>
                            <div class="col-sm-9">
                                <c:if test="${not empty model.thumbnail}">
                                    <img src="${model.thumbnail}" style="cursor: pointer" onclick="$('#image').click()" id="img_url" alt="Your image" width="80px" height="60px"/>
                                    <input type="file" style="display: none" class="form-control" id="image" name="image" value="${model.thumbnail}" />
                                    <script>
                                        $("#image").change(function(){
                                            readURL(this);
                                        });
                                        function readURL(input) {
                                            if (input.files && input.files[0]) {
                                                var reader = new FileReader();
                                                reader.onload = function (e) {
                                                    $('#img_url').attr('src', e.target.result);
                                                }
                                                reader.readAsDataURL(input.files[0]);
                                            }
                                        }
                                    </script>
                                </c:if>
                                <c:if test="${empty model.thumbnail}">
                                    <img src="" onclick="$('#image').click()" style="display: none;" id="editImg" alt="Your image" width="80px" height="60px"/>
                                    <input type="file" style="margin-bottom: 5px;" class="form-control" id="image" name="image"/>
                                    <script>
                                        $("#image").change(function(){
                                            if (document.querySelector('#image').files[0]) {
                                                $('#editImg').css({
                                                    'cursor': 'pointer',
                                                    'display': 'block'
                                                });
                                                $('#image').css({
                                                    'display': 'none'
                                                });
                                                readURL(this);
                                            }
                                        });
                                        function readURL(input) {
                                            if (input.files && input.files[0]) {
                                                var reader = new FileReader();

                                                reader.onload = function (e) {
                                                    $('#editImg').attr('src', e.target.result);
                                                }
                                                reader.readAsDataURL(input.files[0]);
                                            }
                                        }
                                    </script>
                                </c:if>
                            </div>
                        </div>

                        <br/>
                        <br/>
                        <br/>
                        <div class="form-group">
                            <label class="col-sm-3 control-label no-padding-right">Mô tả ngắn</label>
                            <div class="col-sm-9">
                                <input type="text" class="form-control" id="shortDescription" name="shortDescription"
                                       value="${model.shortDescription}"/>
                            </div>
                        </div>
                        <br/>
                        <br/>
                        <div class="form-group">
                            <label class="col-sm-3 control-label no-padding-right">Nội dung</label>
                            <div class="col-sm-9">
                                <textarea rows="" cols="" class="ckeditor" id="content" name="content"
                                          style="width: 820px;height: 175px">${model.content}</textarea>
                            </div>
                        </div>
                        <br/>
                        <br/>
                        <input type="hidden" value="${model.id}" id="id" name="id"/>
                        <br/>
                        <br/>
                        <div class="form-group">
                            <div class="col-sm-12">
                                <c:if test="${not empty model.id}">
                                    <input type="button" class="btn btn-white btn-warning btn-bold"
                                           value="Cập nhật bài viết" id="btnAddOrUpdateNew"/>
                                </c:if>
                                <c:if test="${empty model.id}">
                                    <input type="button" class="btn btn-white btn-warning btn-bold"
                                           value="Thêm bài viết" id="btnAddOrUpdateNew"/>
                                </c:if>
                            </div>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>
<script>

    const toBase64 = file => new Promise((resolve, reject) => {
        const reader = new FileReader();
        reader.readAsDataURL(file);
        reader.onload = () => resolve(reader.result);
        reader.onerror = error => reject(error);
    });

    $('#btnAddOrUpdateNew').click(async function (e) {
        e.preventDefault();
        var data = {};
        var formData = $('#formSubmit').serializeArray();
        $.each(formData, function (i, v) {
            data["" + v.name + ""] = v.value;
        });
        console.log("HHHHHHHHHHHJJJJJJ " + document.querySelector('#image').files[0]);
        if (document.querySelector('#image').files[0]) {
            var file = document.querySelector('#image').files[0];
            var endcodeString  = await toBase64(file);
            console.log("XXXXXXXX: " + endcodeString);
            data['thumbnail'] = endcodeString;
        }
        data['content'] = CKEDITOR.instances['content'].getData();
        var id = $('#id').val();
        if (id == "") {
            addNew(data);
        } else {
            updateNew(data);
        }
    });

    function addNew(data) {
        $.ajax({
            url: '${APIurl}',
            type: 'POST',
            contentType: "application/json",
            data: JSON.stringify(data),
            dataType: 'json',
            success: function (result) {
                window.location.href = "${Newurl}?type=edit&id=" + result.id + "&message=insert_success";
            },
            error: function (error) {
                window.location.href = "${Newurl}?type=list&maxPageItem=2&page=1&message=error_system";
            }

        });
    }

    function updateNew(data) {
        $.ajax({
            url: '${APIurl}',
            type: 'PUT',
            contentType: "application/json",
            data: JSON.stringify(data),
            dataType: 'json',
            success: function (result) {
                window.location.href = "${Newurl}?type=edit&id=" + result.id + "&message=update_success";
            },
            error: function (error) {
                window.location.href = "${Newurl}?type=list&maxPageItem=2&page=1&message=error_system";
            }
        });
    }

</script>
</body>
</html>
