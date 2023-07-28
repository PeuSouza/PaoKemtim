document.querySelector("form").addEventListener("submit", function (event) {
    event.preventDefault();

    const form = document.querySelector("form");
    const x = new XMLHttpRequest();
    const url = form.getAttribute("action");

    x.open("post", url, true);
    x.setRequestHeader("Content-Type", "application/json");
    x.onreadystatechange = function() {
     
        if (x.readyState === 4 && x.status === 200) {
        alert("Item foi cadastrado corretamente!");
        location.reload();
      } else if (x.readyState === 4) {
        alert("Erro ao cadastrar o item.");
        location.reload();
      }
    };
    
    const objectJSON = formToObjectJSON(form);
    x.send(objectJSON);
  });
  
  function formToObjectJSON(form) {
    const formData = new FormData(form);
    let object = {};
    for (let [key, value] of formData) {
      object[key] = value;
    }
    return JSON.stringify(object);
  }