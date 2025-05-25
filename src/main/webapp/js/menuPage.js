
document.addEventListener("DOMContentLoaded", () => {
    document.querySelectorAll(".btn-menu-modifier").forEach(btn => {
        btn.addEventListener("click", (e) => {
            const menu = {
                idplat: btn.getAttribute("data-idplat"),
                nomplat: btn.getAttribute("data-nomplat"),
                pu: btn.getAttribute("data-pu")
            };
            handleModifier(menu);
        });
    });
});


const handleModifier = (menu) => {
    const inputIdplat = document.querySelector(".update-form > #idplat");
    const inputNomplat = document.querySelector(".update-form > #nomplat");
    const inputPu = document.querySelector(".update-form > #pu");
    console.log("menu is here, ", menu);

    inputIdplat.value = menu.idplat;
    inputNomplat.value = menu.nomplat;
    inputPu.value = menu.pu;

}