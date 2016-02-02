~function($) {
  var totalPages;
  var totalEntities = $('#totalEntities').val();
  var pageSize = $('#pageSize').children('option:selected').val();
  var systemType = $('#type').val();
  var hobby = $('#hobby').val();
  var level = $('#level').val();
  var editStatus = $('#editStatus').val() ? $('#editStatus').val() : '';
  var isEnable = $('#isEnable').val() ? $('#isEnable').val() : '';
  var isDelete = $('#isDelete').val() ? $('#isDelete').val() : '';
  var title = $('#title').val();
  title = title === '' ? '' : decodeURI(title);
  var searchParams = ''

  //init search section
  searchParams += initPageSearchParam('type', systemType) + initPageSearchParam('hobby', hobby) +
    initPageSearchParam('level', level) + initPageSearchParam('editStatus', editStatus) +
    initPageSearchParam('isEnable', isEnable) + initPageSearchParam('isDelete', isDelete);

  if(title !== '') {
    searchParams += '&title=' + title;
    $('#titleQuestion').val(title);
  }

  if(totalEntities) {
    totalPages = Math.ceil(totalEntities / pageSize);
    totalPages = totalPages > 0 ? totalPages : 1;
  } else {
    totalPages = 1;
  }
  var numberOfPages = totalPages < 5 ? totalPages : 5;



  var options = {
    bootstrapMajorVersion:3,
    currentPage: $('#currentPage').val() || 1,
    numberOfPages: numberOfPages,
    totalPages: totalPages,
    pageUrl: function(type, page, current) {
      return '/' + $('#urlRoot').val() + '?page=' + page + '&pageSize=' + pageSize + searchParams;
    }
  }
  $('#subtasksPaginatoion').bootstrapPaginator(options);

  $('#pageSize').change(function() {
    var pageSize = $(this).children('option:selected').val();
    var currentUrl = window.location.href;
    var url = currentUrl.indexOf('?') > -1 ? currentUrl.slice(0, currentUrl.indexOf('?'))
      : currentUrl.slice(0, currentUrl.length);
    window.location.href = url + '?pageSize=' + pageSize + searchParams;
  });


  $('.search').click(function() {
    var hobby = $('.hobby').children('option:selected').val();
    var type = $('.type').children('option:selected').val();
    var editStatus = $('.editStatus') ? $('.editStatus').children('option:selected').val() : '';
    var isEnable = $('.isEnable') ? $('.isEnable').children('option:selected').val() : '';
    var level = $('.level') ? $('.level').children('option:selected').val() : '';
    var isDelete = $('.isDelete') ? $('.isDelete').children('option:selected').val() : '';
    var title = $('#titleQuestion').val();
    title = title === '' ? '' : encodeURI(title);

    var currentUrl = window.location.href;
    var url = currentUrl.indexOf('?') > -1 ? currentUrl.slice(0, currentUrl.indexOf('?'))
      : currentUrl.slice(0, currentUrl.length);

    url = url + '?pageSize=' + pageSize + addSearchParam('hobby', hobby) + addSearchParam('type', type) +
      addSearchParam('editStatus', editStatus) + addSearchParam('isEnable', isEnable) + addSearchParam('level', level) +
      addSearchParam('title', title) + addSearchParam('isDelete', isDelete);

    window.location.href = url;
  });

  function initPageSearchParam(param, paramValue) {
    if(paramValue !== '') {
      $('.' + param + ' option').filter(function() {
        return $(this).val().toString() == paramValue;
      }).prop('selected', true);
      return '&' + param + '=' + paramValue;
    }
    return '';
  }
  
  function addSearchParam(param, paramValue) {
    if(paramValue && paramValue !== '') {
      return '&' + param + '=' + paramValue;
    }
    return '';
  }

}($);
