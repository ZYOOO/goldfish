$(function () {
    $("#selectMission").click(function () {
        if ($("#selectMission").val() == "选择") {
            $("#selectMission").attr("value", "完成");
            $(".mis_box").prop("disabled", false);
        } else {
            $("#selectMission").attr("value", "选择");
            $(".mis_box").prop("disabled", true);
        }
    });
    $("#selectSchedule").click(function () {
        if ($("#selectSchedule").val() == "选择") {
            $("#selectSchedule").attr("value", "完成");
            $(".schedule_box").prop("disabled", false);
        } else {
            $("#selectSchedule").attr("value", "选择");
            $(".schedule_box").prop("disabled", true);
        }
    });
    $("#selectAllSchedule").click(function (){
        if ($("#selectAllSchedule").val() == "全选"){
            $(".schedule_box").prop("disabled",false);
            $("#selectAllSchedule").attr("value","取消全选");
            $(".schedule_box").attr("checked",true);

        }else{
            $("#selectAllSchedule").attr("value","全选");
            $(".schedule_box").attr("checked",false);
            $(".schedule_box").prop("disabled",true);

        }
    })
    $("#selectAllMission").click(function (){
        if ($("#selectAllMission").val() == "全选"){
            $(".mis_box").prop("disabled",false);
            $("#selectAllMission").attr("value","取消全选");
            $(".mis_box").attr("checked",true);

        }else{
            $("#selectAllMission").attr("value","全选");
            $(".mis_box").attr("checked",false);
            $(".mis_box").prop("disabled",true);

        }
    })
})