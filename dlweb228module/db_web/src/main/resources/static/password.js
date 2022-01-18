layui.use(['form','jquery'],
    function() {

        $ = layui.jquery;
        var form = layui.form;
                    //监听提交
        form.on('submit(login)',
            function (data) {
                var user_name = document.getElementById("user_name").value;
                var user_pwd = document.getElementById("user_pwd").value;
                //发异步，把数据提交给后端
                $.ajax({
                    url: "/login",
                    data: {
                        user_name: user_name,
                        user_pwd: user_pwd,
                    },
                    type: "Post",
                    dataType: "json",
                    success: function (data) {
                        if (data.result === "success") {
                            location.href = "/index";
                        } else {
                            document.getElementById("user_name").value = "";
                            document.getElementById("user_pwd").value = "";
                        }
                    }
                });
                return false;
            });

    })
