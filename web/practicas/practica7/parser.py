
text = " <option>Álvaro Obregón</option>\n" +"                    <option>Azcapotzalco</option>\n" +"                    <option>Benito Juárez</option>\n" +"                    <option>Coyoacán</option>\n" +"                    <option>Cuajimalpa de Morelos</option>\n" +"                    <option>Cuauhtémoc</option>\n" +"                    <option>Gustavo A. Madero</option>\n" +"                    <option>Iztacalco</option>\n" +"                    <option>Iztapalapa</option>\n" +"                    <option>Magdalena Contreras</option>\n" +"                    <option>Miguel Hidalgo</option>\n" +"                    <option>Milpa Alta</option>\n" +"                    <option>Tláhuac</option>\n" +"                    <option>Tlalpan</option>                    \n" +"                    <option>Venustiano Carranza</option>\n" +"                    <option>Xochimilco</option>                 "
text = text.replace("<option>", "").replace("</option>", "").replace(" ", "")
items = text.split("\n")
res = ""
for item in items:
    res += "<option value=\""+item+"\">" +item+ "</option>\n"


print(res)
