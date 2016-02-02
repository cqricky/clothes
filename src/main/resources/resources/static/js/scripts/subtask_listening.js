/**
 * Created by wudongbo on 2015/11/26.
 */
$(document).ready(function() {
	/*if($('#thirdpartyContentId').val() != ''){
		$('#thirdpartyContentId').attr("readonly","readonly");
	}*/
	if ($("#bilingualSelect") && $("#bilingualSelect").length > 0) {
		$('#bilingualSelect').change(function () {
			var bilingual = $(this).children('option:selected').val();
			if ($("#trsLrc") && $("#trsLrc").length > 0) {
				if (bilingual == 'true') {
					$('#trsLrc').attr('required', true);
				} else {
					$('#trsLrc').removeAttr('required');
				}
			}
		})
	}
});

function fetchAudioUrl(typeCode){
	if($('#contentId').val() != ''){
		var url = '/subtasks/audio_url?contentId='+$('#contentId').val() + '&typeCode='+typeCode + '&subtaskId='+($('#subtaskId').val() || '');
		$.get(url, function (data, status) {
			if(data ){
				if(data.status==0){
					$('#audioUrl').val(data.data.audioUrl);
					if(data.data.duration)
						$('#duration').val(data.data.duration);
				} else {
					alert(data.message);
				}
			}
		});
	}
}

function fetchActivity(typeCode){
	if($('#thirdpartyContentId').val() != ''){
		var url = '/subtasks/activity?activity_id='+$('#thirdpartyContentId').val() + '&typeCode='+typeCode + '&subtaskId='+($('#subtaskId').val() || '');
		$.get(url, function (data, status) {
			if(data ){
				if(data.status==0){
					$('#contentId').val(data.data.contentId);
					$('#audioUrl').val(data.data.audioUrl);
					$('#duration').val(data.data.duration);
					$('#title').val(data.data.title);
					$('#digest').val(data.data.digest);
				} else {
					alert(data.message);
					$('#thirdpartyContentId').focus();
				}
			}
		});
	}
}