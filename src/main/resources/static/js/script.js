document.getElementById("searchInput").addEventListener("input", function() {
    var searchValue = this.value.toLowerCase();
    var rows = document.querySelectorAll("tr[data-searchable]");
    
    rows.forEach(function(row) {
        var visible = false;
        var cells = row.getElementsByTagName("td");
        
        for (var i = 0; i < cells.length; i++) {
            var cellValue = cells[i].textContent.toLowerCase();
            
            if (cellValue.includes(searchValue)) {
                visible = true;
                break;
            }
        }
        
        row.style.display = visible ? "" : "none";
    });
});