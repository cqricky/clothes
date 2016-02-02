/**
 * Created by wudongbo on 2015/9/15.
 */
$(document).ready(function() {
    if($('#relatedTask').val() !=''){
        //$('#linkUrl').attr("readOnly", true);
    }
    $('#relatedTask').change(function(){
        var taskId = $(this).val();
        if(taskId !=''){
            $('#linkUrl').attr("readOnly", true);
            $('#linkUrl').val('hujiang://com.hujiang.normandy/taskmenu?taskid='+taskId);
        } else {
            $('#linkUrl').removeAttr("readonly");
            $('#linkUrl').val('');
        }
    });
});