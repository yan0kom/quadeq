$(document).ready(function () {
  $('#evalHistoryBtn').on('click', onClick_evalHistoryBtn);
});

function onClick_evalHistoryBtn() {
  $.getJSON("/history", function (data) {
    var entries = data.entries;
    if (entries.length == 0) {
      $('.historyBlock').text('История пуста');
    } else {
      $('.historyBlock').html('')
      var table = $('<table><tr><th>Дата/Время</th><th>Уравнение</th><th>x&#8321;</th><th>x&#8322;</th><th>Ошибка</th></tr></table>')
      $.each(entries, function (key, entry) {
        var eq = entry.quadEq

        var col1 = '<td>' + $.format.date(Date.parse(entry.ts), "yyyy-MM-dd HH:mm:ss.SSS") + '</td>'

        var col2 = '<td>'
        if (eq.a != 0) {
          col2 += '<b>' + eq.a + '</b>x&#178;'
        }
        if (eq.b != 0) {
          col2 += (eq.a != 0 ? (eq.b > 0 ? ' + ' : ' - ') : (eq.b > 0 ? ' ' : ' -')) +'<b>' + Math.abs(eq.b) + '</b>x'
        }
        if (eq.c != 0) {
          col2 += (eq.a != 0 || eq.b != 0 ? (eq.c > 0 ? ' + ' : ' - ') : (eq.c > 0 ? ' ' : ' -')) + '<b>' + Math.abs(eq.c) + '</b>'
        }
        col2 += (col2.length > 4 ? '' : '0') + ' = 0</td>'

        var col34 = ''
        if (eq.error != null) {
          col34 = '<td colspan="2"></td>'
        } else if (eq.rootCount == 0) {
          col34 = '<td colspan="2">Корней нет</td>'
        } else if (eq.rootCount == 1) {
          col34 = '<td colspan="2">' + eq.x1 + '</td>'
        } else if (eq.rootCount == 2) {
          col34 = '<td>' + eq.x1 + '</td>' + '<td>' + eq.x2 + '</td>'
        }

        var col5 = '<td>' + (eq.error != null ? eq.error : '') + '</td>'

        $('<tr>' + col1 + col2 + col34 + col5 + '</tr>').appendTo(table)
      })
      table.appendTo($('.historyBlock'))
    }
  });
}
