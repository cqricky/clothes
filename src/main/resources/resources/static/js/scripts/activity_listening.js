/**
 * Created by wudongbo on 2015/11/26.
 */
$(document).ready(function () {
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

    $('#audio').on('timeupdate', function () {
        if(!this.endTime){
            return;
        }

        if (this.currentTime > this.endTime) {
            this.pause();
        }
    }).on('canplay', function () {
        $('.audio-play').removeClass('disabled');
    });

    $('.audio-play').click(function () {
        var player = document.getElementById('audio'),
            index = parseInt($(this).attr('data-index')) + 1,
            selector = 'a[data-index="{0}"]'.replace('{0}', String(index));

        player.currentTime = converToSeconds($(this).attr('data-time-tag'));
        player.endTime = converToSeconds($(selector).attr('data-time-tag'));
        player.play();
    })
});

function converToSeconds(str) {
    if ($.trim(str) === '') {
        return 0;
    }

    var parts = str.split(':');

    return Math.round(parts[0]) * 60 + parts[1];

}

function fetchAudioUrl(typeCode) {
    if ($('#contentId').val() != '') {
        var url = '/activities/audio_url?contentId=' + $('#contentId').val() + '&typeCode=' + typeCode + '&activityId=' + $('#activityId').val();
        $.get(url, function (data, status) {
            if (data) {
                if (data.status == 0) {
                    $('#audioUrl').val(data.data.audioUrl);
                    if (data.data.duration)
                        $('#duration').val(data.data.duration);

                    $('#btnSave').removeAttr('disabled');

                } else {
                    alert(data.message);
                    $('#btnSave').attr('disabled', true);
                }
            }
        });
    }
}