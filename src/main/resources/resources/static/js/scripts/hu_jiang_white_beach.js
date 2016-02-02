~function($) {
  //change language
  $('a[id="languageSelect"]').click(function() {
    var languageId = $(this).attr('languageId');
    $.ajax({
      "url": "/languages/switch",
      "type": "post",
      "data": {
        "languageId": languageId
      },
      "dataType": "json",
      "success": function(data) {
        var currentUrl = window.document.location.href;
        var pathName = window.document.location.pathname;
        var baseUrl;
        if(data.status === 0) {
          var url;
          if(pathName === '/') {
            url = currentUrl;
          } else {
            baseUrl = currentUrl.slice(0, currentUrl.indexOf(pathName));
            if(pathName.indexOf('/', 1) > -1) {
              url = baseUrl + pathName.slice(0, pathName.indexOf('/', 1));
            } else {
              url = currentUrl;
            }
          }
          window.location.href = url;
        } else if (data.status === -1) {
          if(pathName === '/') {
            baseUrl = currentUrl;
          } else {
            baseUrl = currentUrl.slice(0, currentUrl.indexOf(pathName)) + '/';
          }
          window.location.href = baseUrl + 'admins/login';
        } else {
          alert('系统错误!');
        }
      },
      "error": function(data) {
        if(JSON.stringify(data).indexOf('Log in') > -1) {
          var currentUrl = window.document.location.href;
          var pathName = window.document.location.pathname;
          var baseUrl;
          if(pathName === '/') {
            baseUrl = currentUrl;
          } else {
            baseUrl = currentUrl.slice(0, currentUrl.indexOf(pathName)) + '/';
          }
          window.location.href = baseUrl + 'admins/login';
        } else {
          alert('系统错误!');
        }
      }
    });

  });


  //delete
  $('a[id="delete"]').click(function() {
    var currentUrl = window.document.location.href;
    var pathName = window.document.location.pathname;
    var baseUrl;
    if(pathName === '/') {
      baseUrl = currentUrl;
    } else {
      baseUrl = currentUrl.slice(0, currentUrl.indexOf(pathName));
    }
    var obj = $(this).attr('obj').toString();
    var objId = $(this).attr('objId').toString();
    var url = baseUrl + '/' + obj + '/' + objId;

    if(confirm("确定要删除此条记录吗?")) {
      $.ajax({
        "url": url,
        "type": "delete",
        "dataType": "json",
        "success": function(data) {
          if(data.status === "success") {
            window.location.reload();
          } else {
            alert('删除失败!');
          }
        },
        "error": function(data) {
          alert('删除失败!');
        }

      });
    }
  });


  //undelete
  $('a[id="undelete"]').click(function() {
    var currentUrl = window.document.location.href;
    var pathName = window.document.location.pathname;
    var baseUrl;
    if(pathName === '/') {
      baseUrl = currentUrl;
    } else {
      baseUrl = currentUrl.slice(0, currentUrl.indexOf(pathName));
    }
    var obj = $(this).attr('obj').toString();
    var objId = $(this).attr('objId').toString();
    var url = baseUrl + '/' + obj + '/undelete/' + objId;

    //alert(url);

    if(confirm("确定要恢复此条记录吗?")) {
      $.ajax({
        "url": url,
        "type": "post",
        "dataType": "json",
        "success": function(data) {
          if(data.status === "success") {
            window.location.reload();
          } else {
            alert('删除失败!');
          }
        },
        "error": function(data) {
          alert('删除失败!');
        }

      });
    }
  });


  //delete
  $('a[id="deleteTaskContent"]').click(function() {
    var currentUrl = window.document.location.href;
    var pathName = window.document.location.pathname;
    var baseUrl;
    if(pathName === '/') {
      baseUrl = currentUrl;
    } else {
      baseUrl = currentUrl.slice(0, currentUrl.indexOf(pathName));
    }
    var deleteUrl = $(this).attr('deleteUrl').toString();
    console.log("baseUrl: " + baseUrl);
    console.log("deleteUrl: " + deleteUrl);
    var url = baseUrl + deleteUrl;
    //var objId = $(this).attr('objId').toString();
    //var url = baseUrl + '/' + obj + '/' + objId;

    if(confirm("确定要删除此条记录吗?")) {
      $.ajax({
        "url": url,
        "type": "delete",
        "dataType": "json",
        "success": function(data) {
          if(data.status === "success") {
            window.location.reload();
          } else {
            alert('删除失败!');
          }
        },
        "error": function(data) {
          alert('删除失败!');
        }

      });
    }
  });

  //update
  $('a[id="update"]').click(function() {
    var currentUrl = window.document.location.href;
    var pathName = window.document.location.pathname;
    var baseUrl;
    if(pathName === '/') {
      baseUrl = currentUrl;
    } else {
      baseUrl = currentUrl.slice(0, currentUrl.indexOf(pathName));
    }
    var obj = $(this).attr('obj').toString();
    var objId = $(this).attr('objId').toString();
    var url = baseUrl + '/' + obj + '/edit/' + objId;

    if(currentUrl.indexOf('?') > -1) {
      url = url + '?ext=' + encodeURIComponent(currentUrl.slice(currentUrl.indexOf('?'), currentUrl.length));
    }

    window.location.href = url;
  });

  //update listening
  $('a[id="updateListening"]').click(function() {
    var currentUrl = window.document.location.href;
    var pathName = window.document.location.pathname;
    var baseUrl;
    if(pathName === '/') {
      baseUrl = currentUrl;
    } else {
      baseUrl = currentUrl.slice(0, currentUrl.indexOf(pathName));
    }
    var obj = $(this).attr('obj').toString();
    var objId = $(this).attr('objId').toString();
    var url = baseUrl + '/' + obj + '/edit/' + objId;

    if(currentUrl.indexOf('?') > -1) {
      url = url + '?ext=' + encodeURIComponent(currentUrl.slice(currentUrl.indexOf('?'), currentUrl.length));
    }

    window.location.href = url;
  });

  //update LRC
  $('a[id="updateLRCQuestion"]').click(function() {
    var currentUrl = window.document.location.href;
    var pathName = window.document.location.pathname;
    var baseUrl;
    if(pathName === '/') {
      baseUrl = currentUrl;
    } else {
      baseUrl = currentUrl.slice(0, currentUrl.indexOf(pathName));
    }
    var obj = $(this).attr('obj').toString();
    var objId = $(this).attr('objId').toString();
    var url = baseUrl + '/' + obj + '/edit/' + objId;
    var ext = $(this).attr('ext').toString();

    url = url + '?ext=' + ext;

    window.location.href = url;
  });

}($);