$(document)
    .ready(
        function() {
            $('#encr').click(function() {
                var row = $('#optionR').val();
                var col = $('#optionC').val();
                var data = "";

                for (var i = 1; i <= row; i++) {
                    for (var j = 1; j <= col; j++) {
                        var idCell = "cell" + i + j;
                        data += $('#' + idCell).val();
                    }
                    if (i != row) {
                        data += ",";
                    }
                }
                $.ajax({
                    url: 'playFairController',
                    data: {
                        key: data,
                        plantText: $('#plantTextpf').val()
                    },
                    success: function(responseText) {
                        $('#kq1').text(responseText);
                    }
                });
            });
            $('#btn').click(function() {
                $.ajax({
                    url: 'cipherController',
                    data: {
                        option: $('#option').val()
                    },
                    success: function(responseText) {
                        $('#ajax-data').text(responseText);
                    }
                });
            });
            $('#btnOk')
                .click(
                    function() {
                        var alp = shuffle();
                        var row = $('#optionR').val();
                        var col = $('#optionC').val();
                        var dem = 0;
                        var rs = '<table><tbody>';
                        for (var i = 1; i <= row; i++) {
                            rs += '<tr>';
                            for (var j = 1; j <= col; j++) {
                                rs += "<td><input id='cell" +
                                    i +
                                    j +
                                    "' maxlength='1'  style='width: 45px;' value='" +
                                    alp[dem] + "'></td>";
                                dem++;
                            }
                            rs += "</tr>";
                        }
                        rs += "</tbody></table>";
                        $('#ajax-matrix').html(rs);
                    });

            $('#btnchon').click(function() {
                $.ajax({
                    url: 'vigennereController',
                    data: {
                        planttext2: $('#planttext2').val(),
                        key2: $('#key2').val(),
                    },
                    success: function(responseText) {
                        $('#ajax-data2').text(responseText);
                    }
                });
            });

            $('#btnCreate')
                .click(
                    function() {
                        var alp = shuffle();
                        var row = $('#optionRow').val();
                        var col = $('#optionCol').val();
                        var dem = 0;
                        var rs = '<table><tbody>';
                        for (var i = 1; i <= row; i++) {
                            rs += '<tr>';
                            for (var j = 1; j <= col; j++) {
                                rs += "<td><input id='cell" +
                                    i +
                                    j +
                                    "' maxlength='1'  style='width: 45px;' value='" +
                                    alp[dem] + "'></td>";
                                dem++;
                            }
                            rs += "</tr>";
                        }
                        rs += "</tbody></table>";
                        $('#ajax-matrix2').html(rs);
                    });
            $('#btnCreateMatrixSq')
            .click(
                function() {
                    var alp = shuffle1();
                    var row = $('#RowMatrixSq').val();
                    var dem = 0;
                    var rs = '<table><tbody>';
                    for (var i = 1; i <= row; i++) {
                        rs += '<tr>';
                        for (var j = 1; j <= row; j++) {
                            rs += "<td><input id='cellMatrix" +
                                i +
                                j +
                                "' maxlength='2'  style='width: 45px;' value='" +
                                alp[dem] + "'></td>";
                            dem++;
                        }
                        rs += "</tr>";
                    }
                    rs += "</tbody></table>";
                    $('#ajax-matrix2').html(rs);
                });
            $('#Encrypt').click(function() {
                var row = $('#RowMatrixSq').val();
                var data = "";

                for (var i = 1; i <= row; i++) {
                    for (var j = 1; j <= row; j++) {
                        var idCell = "cellMatrix" + i + j;
                        data += $('#' + idCell).val() + "%";
                    }
                    if (i != row) {
                        data += ",";
                    }
                    
                }
                $.ajax({
                    url: 'hillController',
                    data: {
                    	hillText: $('#hillText').val(),
                    	data:data
                    	
                    },
                    success: function(responseText) {
                        $('#kq2').text(responseText);
                    }
                });
            });
        });





function selectCipher(obj) {
    var value = obj.value;
    if (value === 'playfair') {
        $('#pf').removeClass("hideContent");
        $('#vi').addClass("hideContent");
        $('#hi').addClass("hideContent");
    } else if (value === 'vigennere') {
        $('#vi').removeClass("hideContent");
        $('#pf').addClass("hideContent");
        $('#hi').addClass("hideContent");
    } else if (value === 'hill') {
        $('#hi').removeClass("hideContent");
        $('#vi').addClass("hideContent");
        $('#pf').addClass("hideContent");
    }

}

function shuffle() {
    var array = new Array("A", "B", "C", "D", "E", "F", "G", "H", "I", "K",
        "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X",
        "Y", "Z");
    var m = array.length,
        t, i;
    // Chừng nào vẫn còn phần tử chưa được xáo trộn thì vẫn tiếp tục
    while (m) {
        // Lấy ra 1 phần tử
        i = Math.floor(Math.random() * m--);
        // Sau đó xáo trộn nó
        t = array[m];
        array[m] = array[i];
        array[i] = t;
    }
    return array;
}

function shuffle1() {
    var array = new Array("1", "2", "3", "4", "5", "6", "7", "8", "9", "10",
        "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23",
        "24", "25");
    var m = array.length,
        t, i;
    // Chừng nào vẫn còn phần tử chưa được xáo trộn thì vẫn tiếp tục
    while (m) {
        // Lấy ra 1 phần tử
        i = Math.floor(Math.random() * m--);
        // Sau đó xáo trộn nó
        t = array[m];
        array[m] = array[i];
        array[i] = t;
    }
    return array;
}