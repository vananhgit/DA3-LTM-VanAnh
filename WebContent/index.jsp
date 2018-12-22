<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
    <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
    <html>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Insert title here</title>
        <script src="https://code.jquery.com/jquery-1.10.2.js" type="text/javascript"></script>
        <!-- Latest compiled and minified CSS -->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">

        <!-- Latest compiled and minified JavaScript -->
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
        <link type="text/css" rel="stylesheet" href="<%=request.getContextPath()%>/css/style.css" />
        <script src="js/app-ajax.js" type="text/javascript"></script>
    </head>

    <body>
        <div class="wrapper-cmt">
            <div class="cmt-post">
                <div class="detail">
                    <h1>ỨNG DỤNG THỰC HIỆN CHỨC NĂNG MÃ HÓA</h1>
                    <br>
                    <center>
                        <select class="option" id="option" onchange="selectCipher(this)">
                            <option value="playfair">Mã hóa PLAYFAIR</option>
                            <option value="vigennere">Mã hóa VIGENNÈRE</option>
                            <option value="hill">Mã hóa HILL</option>
                        </select>
                    </center>
                    <br>
                </div>
            </div>
            <div id="pf" class="">
                <div>
                    <center>
                        <form id="cipher_playfair" method="post">
                        	<textarea name="plaintext" id="plantTextpf" style="width: -webkit-fill-available;" placeholder="Enter plant text"></textarea>
                        </form>
                        <div class="matrixSize">
                            <br>
                            <br>
                            <label class="">Grid</label>
                            <select class="option" id="optionR">
	                            <option value="1">1</option>
	                            <option value="2">2</option>
	                            <option value="3">3</option>
	                            <option value="4">4</option>
	                            <option value="5" selected="selected">5</option>
	                        </select>
	                        X
	                        <select class="option" id="optionC">
	                            <option value="1">1</option>
	                            <option value="2">2</option>
	                            <option value="3">3</option>
	                            <option value="4">4</option>
	                            <option value="5" selected="selected">5</option>
	                        </select>
                            <button id="btnOk">Create</button>
                        </div>
                        <div id="ajax-matrix"></div>
                        <br>
                        <button id="encr">Encrypt</button>
                        <br><br>
                         <div id="kq1"></div>
                    </center>
                </div>
                <div id="ajax-data"></div>
            </div>

            <div id="vi" class="hideContent">
                <div>
                    <form class="form-cmt">
                        <div class="form-item">
                            <input type="text" name="planttext" id="planttext2" value="" placeholder="Nhập văn bản" required="required" />
                        </div>
                        <div class="form-item">
                            <input type="text" name="key" id="key2" value="" placeholder="Nhập khóa K" required="required" /> 
                            <a href="javascript:void(0)" title="" id="btnchon" onclick="">Chọn</a>
                        </div>
                    </form>
                </div>
                <div id="ajax-data2"></div>
            </div>

            <div id="hi" class="hideContent">
                <center>
                    <form id="cipher_hill">
                        <label for="cipher_hill_plaintext">Hill plain text</label>
                        <br>
                        <textarea name="plaintext" id="hillText" style="width: -webkit-fill-available;" placeholder="Enter plant text"></textarea>
                    </form>
                    <div class="matrixSize">
                            <br>
                            <br>
                            <label class="">Ma trận Khóa K vuông cấp: </label>
                            <select class="option" id="RowMatrixSq">
	                            <option value="1">1</option>
	                            <option value="2">2</option>
	                            <option value="3" selected="selected">3</option>
	                            <option value="4">4</option>
	                            <option value="5">5</option>
	                        </select>
                            <button id="btnCreateMatrixSq">Create</button>
                        </div>
                        <div id="ajax-matrix2"></div>
                        <br>
                        <button><a href="javascript:void(0)"  id="Encrypt">Encrypt</a></button>
                        <br>
                        <br><br>
                         <div id="kq2"></div>
                </center>
            </div>
        </div>
    </body>

    </html>