<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
        <!DOCTYPE html>
        <html>

        <head>
            <meta charset="UTF-8">
            <title>Dashboard</title>
            <c:url value="/static/admin/css/admin.css" var="bootstrap"></c:url>
            <link href="${bootstrap}" rel="stylesheet" type="text/css" media="all">

            <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
        </head>

        <body>
            <div class="container">
                <div class="navbar">
	                <div class="admin">
	                <a href="#home"><i class="fa fa-wrench"></i> ALESIA</a>
	                </div>
                    
                    <div class="dropdown">
                        <button class="dropbtn">Xin chào ${user.name} !
                    <i class="fa fa-caret-down"></i>
                </button>
                        <div class="dropdown-content">
                            <a href="#">User Profile</a>
                            <a href="#">Setting</a>
                            <hr />
                            <a href="/Fashion/admin/logout">Log out</a>
                        </div>
                    </div>
                </div>

                <div class="sidenav">
                    <a href="/Fashion/admin/user/list"><div><p class="nav-text">User <i class="ikon fa fa-user"></i></p></div></a>                  
                    <a href="/Fashion/admin/category/list"><div><p class="nav-text">Category <i class="ikon fa fa-list-alt" aria-hidden="true"></i></p></div></a> 

                    <a href="/Fashion/admin/product/list"><div><p class="nav-text">Product <i class="ikon fa fa-product-hunt"></i></p></div></a>  
                    <a href="/Fashion/admin/cart/list"><div><p class="nav-text">Cart <i class="ikon fa fa-shopping-cart"></i></p></div></a> 
                </div>

                <div class="add-content">

                    <br>
                    <h2 align="center">Thêm Product</h2>
                    <div class="add-table">
                        <div class="hr">
                            <hr>
                        </div>
                        <form method="post" id="ha">
                            <input id="idInput" type="hidden" value="">
                            <label>Name</label>
                            <input id="nameInput" type="text" name="name" required="" value="">
                            <div class="hr">
                                <hr>
                            </div>
                            <label>Price</label>
                            <input id="priceInput" type="text" name="price" required="" value="">
                            <div class="hr">
                                <hr>
                            </div>
                            <label>Category</label>
                            <select id="categoryInput" name="category" title="">
							<c:forEach items="${categories}" var="c">
								<option id="categoryId" value="${c.id}" label="${c.name}"></option>
							</c:forEach>
					</select>
                            <div class="hr">
                                <hr>
                            </div>
                            <label>Image product</label>
                            <input id="imgInput" type="file" name="image"> </br>
                            <img id="imgOutput" src="" alt="avt" height="100" width="100">
                            <input type="button" name="add" id="submit" value="Submit" onclick="updateProduct()"> </br>
                        </form>
                    </div>
                </div>
            </div>
            <c:url value="/static/admin/js/product.js" var="test"></c:url>
            <script src="${test}"></script>
        </body>

        </html>