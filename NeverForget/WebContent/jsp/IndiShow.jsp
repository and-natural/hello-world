<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
       <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
       <%@ taglib uri="/struts-tags" prefix="s" %>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>show time</title>
     <link type="text/css" rel="stylesheet"  href="${pageContext.request.contextPath }/statics/css/IndiShow.css" />
   
</head>
<body>
<div class="yemian" >

    <div class="header"><!--页眉-->

        <div class="header_div" ><h1 align="center">个人信息展示</h1>
            <p class="header_a"> <a href="${pageContext.request.contextPath}/jsp/IndiLogin.jsp" >Login in</a></p>
        </div>

    </div>
    <div class="middle">
        <div class="middle_inbox">
            <div class="middle_inbox_top">
                <div class="middle_inbox_topleft">
                    <img class="bean" src="${pageContext.request.contextPath }/statics/images/bean.jpg" alt="头像"/>
                    <div class="explain_01">
                      <li class="explain_01_title">基本信息</li>
                        <li>姓名：${user.username}</li>
                        <li>qq号：1716285028</li>
                        <li>手机号：19503811229</li>
                        <li>现居地：河南省郑州市郑州轻工业大学</li>
                        <li>公司地址: 黑龙江省海伦市海西新区世纪大道8号</li>
                    </div>
                </div>
                <div class="middle_inbox_topright">
                    <div class="middle_inbox_table"  >
                    <table  border="1" width="280px" rules="rows" >
                        <caption><strong>营养成分表</strong></caption>
                        <tr >
                            <th>项目</th>
                            <th>&nbsp;&nbsp;&nbsp;每100克(g)</th>
                            <th>NRV%</th>
                        </tr>
                        <table width="280px"  border="1"rules="none"  >
                        <tr>
                            <td>&nbsp;能量</td>
                            <td>1741千焦(KJ)</td>
                            <td>21%</td>
                        </tr>
                            <tr>
                                <td>&nbsp;蛋白质</td>
                                <td>18.0克(g)</td>
                                <td>30%</td>
                            </tr>
                            <tr>
                                <td>&nbsp;脂肪</td>
                                <td>10.0克(g)</td>
                                <td>17%</td>
                            </tr>
                            <tr>
                                <td>&nbsp;碳水化合物</td>
                                <td>67.0克(g)</td>
                                <td>22%</td>
                            </tr>
                            <tr>
                                <td>&nbsp;钠</td>
                                <td>300毫克(mg)</td>
                                <td>15%</td>
                            </tr>
                        </table>
                    </table>
                    </div>
                </div>
            </div>
            <div class="middle_inbox_down">
                <div class="middle_inbox_downleft">
                    <div class="downleft_top">
                        <div></div>
                        <div class="title2"><h1 class="title2_langu">留言板</h1></div>
                    </div>
                    <div>
                        <form>
                            <h3 >请您填写宝贵意见:</h3>
                            <br/>
                            <div class="input"><textarea name="info"  class="input1" rows="11" cols="75" wrap="virtual"></textarea></div>
                            <div class="flag">
                                <br/>
                            <input id="choice" type="submit" name="" value="提交"/>&nbsp;&nbsp;
                            <input id="choice" type="reset" align="middle">


                            </div>
                        </form>
                    </div>
                </div>
                <div class="middle_inbox_downright">
                <h4>   ☺ 恭喜您，当前是您是第<s:property value="#application.number"/>位登录的用户，是幸运用户哦！</h4> </div>
            </div>

        </div>
    </div><!--中间-->
    <div class="foot"></div><!--尾部-->
    
   
</div>
 
</body>
</html>