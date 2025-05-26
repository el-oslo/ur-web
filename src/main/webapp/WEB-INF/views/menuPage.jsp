<%@ page contentType="text/html;charset=UTF-8" language="java" %> <%@ taglib
prefix="c" uri="jakarta.tags.core" %>
<html>
  <head>
    <base href="${pageContext.request.contextPath}/">
    <link rel="icon" type="image/svg+xml" href="${pageContext.request.contextPath}/assets/UR-logo.svg">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/styles/global.css">
  </head>
  <body>
    <div class="gestion__menu">
       <div class="navbar">
        <div class="logo">
          <p class="font-styled">
            Ryori
          </p>
        </div>
       </div>
       <p class="error">
        <c:if test="${not empty error}">${error}</c:if>
       </p>
      <div class="list">
        <h2>List of Menus</h2>
        <table>
          <thead>
            <tr>
              <th>idplat</th>
              <th>nom</th>
              <th>prix unitaire</th>
              <th>Actions</th>
            </tr>
          </thead>
          <tbody>
            <c:forEach var="menu" items="${menus}">
              <tr>
                <td>${menu.idplat}</td>
                <td>${menu.nomplat}</td>
                <td>${menu.pu}</td>
                <td>
                  <button data-idplat="${menu.idplat}" data-nomplat="${menu.nomplat}" data-pu="${menu.pu}" class="btn-menu-modifier" >Modifier</button>
                  <button>
                    <a href="${pageContext.request.contextPath}/gestion/menus/delete/${menu.idplat}">
                      Suppr
                    </a>
                  </button>
                </td>
              </tr>
            </c:forEach>
          </tbody>
        </table>
      </div>
      <form
        action="${pageContext.request.contextPath}/gestion/menus/create"
        method="post"
      >
        <label for="idplat">ID Plat:</label>
        <input type="text" id="idplat" name="idplat" required />

        <label for="nomplat">Nom Plat:</label>
        <input type="text" id="nomplat" name="nomplat" required />

        <label for="pu">Prix Unitaire:</label>
        <input type="number" id="pu" name="pu" step="0.01" required />

        <button type="submit">Créer</button>
      </form>
      <form
        action="${pageContext.request.contextPath}/gestion/menus/update"
        method="post"
        class="update-form"
      >
        <label for="idplat">ID Plat:</label>
        <input type="text" id="idplat" name="idplat" required />

        <label for="nomplat">Nom Plat:</label>
        <input type="text" id="nomplat" name="nomplat" required />

        <label for="pu">Prix Unitaire:</label>
        <input type="number" id="pu" name="pu" step="0.01" required />

        <button type="submit">Créer</button>
      </form>
    </div>
  </body>
  <script type="module" src="${pageContext.request.contextPath}/js/menuPage.js"></script>
</html>
