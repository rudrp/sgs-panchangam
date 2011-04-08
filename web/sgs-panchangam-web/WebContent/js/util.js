function loadContent(id, file) {
	$.get(file, function(data) {
		$(id).html(data);
	});
}
function buildPanchangamHTML(data) {
	var panchangamHTML = "";
	panchangamHTML += "<table class=\"panchangamTable\" cellpadding=\"1\" cellspacing=\"0\">";
	panchangamHTML += "<tbody><tr>";
	panchangamHTML += "<td colspan=\"2\" rowspan=\"1\" style=\"vertical-align: top; text-align: center\">ఖర నామ సంవత్సరం	2011</td>";
	panchangamHTML += "<td colspan=\"2\" rowspan=\"1\"";
	panchangamHTML += "style=\"vertical-align: top; text-align: center\">"
			+ data['day']['aayanam'] + "</td>";
	panchangamHTML += "<td colspan=\"2\" rowspan=\"1\"";
	panchangamHTML += "style=\"vertical-align: top; text-align: center\">ఈనాటి పర్వము</td>";
	panchangamHTML += "</tr>";
	panchangamHTML += "<tr>";
	panchangamHTML += "<td colspan=\"1\" rowspan=\"2\"";
	panchangamHTML += "style=\"vertical-align: top; text-align: center\">"
			+ data['day']['month'] + " " + data['day']['date'] + "</td>";
	panchangamHTML += "<td style=\"vertical-align: top; text-align: center\">ఋతువు<br>";
	panchangamHTML += "</td>";
	panchangamHTML += "<td style=\"vertical-align: top; text-align: center\">మాసం<br>";
	panchangamHTML += "</td>";
	panchangamHTML += "<td style=\"vertical-align: top; text-align: center\">పక్షం<br>";
	panchangamHTML += "</td>";
	panchangamHTML += "<td colspan=\"2\" rowspan=\"2\"";
	panchangamHTML += "style=\"vertical-align: top; text-align: center\"><span";
	if (data['day']['visesham'] != null) {
		panchangamHTML += "style=\"font-weight: bold\">"
				+ data['day']['visesham'] + "</span><br>";
	} else {
		panchangamHTML += "style=\"font-weight: bold\"> </span><br>";
	}
	panchangamHTML += "</td>";
	panchangamHTML += "</tr>";
	panchangamHTML += "<tr>";
	panchangamHTML += "<td style=\"vertical-align: top; text-align: center\">"
			+ data['currentTithi']['rutuvu'] + "<br>";
	panchangamHTML += "</td>";
	panchangamHTML += "<td style=\"vertical-align: top; text-align: center\">"
			+ data['currentTithi']['maasam'] + "<br>";
	panchangamHTML += "</td>";
	panchangamHTML += "<td style=\"vertical-align: top; text-align: center\">"
			+ data['currentTithi']['paksham'] + "<br>";
	panchangamHTML += "</td>";
	panchangamHTML += "</tr>";
	panchangamHTML += "<tr>";
	panchangamHTML += "<td colspan=\"4\" rowspan=\"1\"";
	panchangamHTML += "style=\"vertical-align: top; text-align: center\"><span";
	panchangamHTML += "style=\"font-size: 12pt; line-height: 115%; font-weight: bold\"";
	panchangamHTML += ">రాశి చక్రం - గ్రహ స్థితి</span><span";
	panchangamHTML += "style=\"font-size: 10pt; line-height: 115%; \"";
	panchangamHTML += "> </span>";
	panchangamHTML += "</td>";
	panchangamHTML += "<td colspan=\"2\" rowspan=\"1\"";
	panchangamHTML += "style=\"vertical-align: top; text-align: center\"><span";
	panchangamHTML += "style=\"font-weight: bold\">లగ్నాంతకాలములు</span><br></td>";
	panchangamHTML += "</tr>";
	panchangamHTML += "<tr>";
	panchangamHTML += "<td colspan=\"1\" rowspan=\"3\"";
	panchangamHTML += "style=\"vertical-align: top; text-align: center\">12 మీనం <br>";
	if (data['raasiChakram']['meenamGrahaSthithi'] != null) {
		panchangamHTML += data['raasiChakram']['meenamGrahaSthithi'] + "</td>";
	} else {
		panchangamHTML += "</td>";
	}
	panchangamHTML += "<td colspan=\"1\" rowspan=\"3\"";
	panchangamHTML += "style=\"vertical-align: top; text-align: center\">1 మేషం<br>";
	if (data['raasiChakram']['meshamGrahaSthithi'] != null) {
		panchangamHTML += data['raasiChakram']['meshamGrahaSthithi'] + "</td>";
	} else {
		panchangamHTML += "</td>";
	}
	panchangamHTML += "<td colspan=\"1\" rowspan=\"3\"";
	panchangamHTML += "style=\"vertical-align: top; text-align: center\">2 వృషభం<br>";
	if (data['raasiChakram']['vrushabhamGrahaSthithi'] != null) {
		panchangamHTML += data['raasiChakram']['vrushabhamGrahaSthithi']
				+ "</td>";
	} else {
		panchangamHTML += "</td>";
	}
	panchangamHTML += "<td colspan=\"1\" rowspan=\"3\"";
	panchangamHTML += "style=\"vertical-align: top; text-align: center\">3 మిథునం<br>";
	if (data['raasiChakram']['mithunamGrahaSthithi'] != null) {
		panchangamHTML += data['raasiChakram']['mithunamGrahaSthithi']
				+ "</td>";
	} else {
		panchangamHTML += "</td>";
	}
	panchangamHTML += "<td style=\"vertical-align: top; text-align: center\">"
			+ data['lagnantakaalamulu']['raasi1'] + "<br>";
	panchangamHTML += "</td>";
	panchangamHTML += "<td style=\"vertical-align: top\">"
			+ data['lagnantakaalamulu']['time1'] + "<br></td>";
	panchangamHTML += "</tr>";
	panchangamHTML += "<tr>";
	panchangamHTML += "<td style=\"vertical-align: top; text-align: center\">"
			+ data['lagnantakaalamulu']['raasi2'] + "<br>";
	panchangamHTML += "</td>";
	panchangamHTML += "<td style=\"vertical-align: top\">"
			+ data['lagnantakaalamulu']['time2'] + "</td>";
	panchangamHTML += "</tr>";
	panchangamHTML += "<tr>";
	panchangamHTML += "<td style=\"vertical-align: top; text-align: center\">"
			+ data['lagnantakaalamulu']['raasi3'] + "<br>";
	panchangamHTML += "</td>";
	panchangamHTML += "<td style=\"vertical-align: top\">"
			+ data['lagnantakaalamulu']['time3'] + "</td>";
	panchangamHTML += "</tr>";
	panchangamHTML += "<tr>";
	panchangamHTML += "<td colspan=\"1\" rowspan=\"3\"";
	panchangamHTML += "style=\"vertical-align: top; text-align: center\">11 కుంభం<br>";
	if (data['raasiChakram']['kumbhamGrahaSthithi'] != null) {
		panchangamHTML += data['raasiChakram']['kumbhamGrahaSthithi'] + "</td>";
	} else {
		panchangamHTML += "</td>";
	}
	panchangamHTML += "<td colspan=\"2\" rowspan=\"1\"";
	panchangamHTML += "style=\"vertical-align: top; text-align: center\">పంచాంగం<br>";
	panchangamHTML += "</td>";
	panchangamHTML += "<td colspan=\"1\" rowspan=\"3\"";
	panchangamHTML += "style=\"vertical-align: top; text-align: center\">4 కర్కాటకం<br>";
	if (data['raasiChakram']['karkatakamGrahaSthithi'] != null) {
		panchangamHTML += data['raasiChakram']['karkatakamGrahaSthithi']
				+ "</td>";
	} else {
		panchangamHTML += "</td>";
	}
	panchangamHTML += "<td style=\"vertical-align: top; text-align: center\">"
			+ data['lagnantakaalamulu']['raasi4'] + "<br>";
	panchangamHTML += "</td>";
	panchangamHTML += "<td style=\"vertical-align: top\">"
			+ data['lagnantakaalamulu']['time4'] + "</td>";
	panchangamHTML += "</tr>";
	panchangamHTML += "<tr>";
	panchangamHTML += "<td colspan=\"2\" rowspan=\"5\" style=\"vertical-align: top;width:40%;\">తిథి -";
	panchangamHTML += data['currentTithi']['tithiName'] + " "
			+ data['currentTithi']['tithiTime'] + " <br>"
			+ data['day']['dayOfTheWeek'] + "<br>నక్షత్రం - "
			+ data['currentNakshatram']['nakshatram'] + " "
			+ data['currentNakshatram']['nakshatramTime'];
	panchangamHTML += "<br>యోగం - " + data['day']['yogam'] + "<br>కరణం-"
			+ data['day']['karanam'] + "<br>";
	panchangamHTML += "</td>";
	panchangamHTML += "<td style=\"vertical-align: top; text-align: center\">"
			+ data['lagnantakaalamulu']['raasi5'] + "<br>";
	panchangamHTML += "</td>";
	panchangamHTML += "<td style=\"vertical-align: top\">"
			+ data['lagnantakaalamulu']['time5'] + "</td>";
	panchangamHTML += "</tr>";
	panchangamHTML += "<tr>";
	panchangamHTML += "<td style=\"vertical-align: top; text-align: center\">"
			+ data['lagnantakaalamulu']['raasi6'] + "<br>";
	panchangamHTML += "</td>";
	panchangamHTML += "<td style=\"vertical-align: top\">"
			+ data['lagnantakaalamulu']['time6'] + "</td>";
	panchangamHTML += "</tr>";
	panchangamHTML += "<tr>";
	panchangamHTML += "<td colspan=\"1\" rowspan=\"3\"";
	panchangamHTML += "style=\"vertical-align: top; text-align: center\">10 మకరం<br>";
	if (data['raasiChakram']['makaramGrahaSthithi'] != null) {
		panchangamHTML += data['raasiChakram']['makaramGrahaSthithi'] + "</td>";
	} else {
		panchangamHTML += "</td>";
	}
	panchangamHTML += "<td colspan=\"1\" rowspan=\"3\" style=\"vertical-align: top\">5 సింహం<br>";
	if (data['raasiChakram']['simhamGrahaSthithi'] != null) {
		panchangamHTML += data['raasiChakram']['simhamGrahaSthithi'] + "</td>";
	} else {
		panchangamHTML += "</td>";
	}
	panchangamHTML += "<td style=\"vertical-align: top; text-align: center\">"
			+ data['lagnantakaalamulu']['raasi7'] + "<br>";
	panchangamHTML += "</td>";
	panchangamHTML += "<td style=\"vertical-align: top\">"
			+ data['lagnantakaalamulu']['time7'] + "</td>";
	panchangamHTML += "</tr>";
	panchangamHTML += "<tr>";
	panchangamHTML += "<td style=\"vertical-align: top; text-align: center\">"
			+ data['lagnantakaalamulu']['raasi8'] + "<br>";
	panchangamHTML += "</td>";
	panchangamHTML += "<td style=\"vertical-align: top\">"
			+ data['lagnantakaalamulu']['time8'] + "</td>";
	panchangamHTML += "</tr>";
	panchangamHTML += "<tr>";
	panchangamHTML += "<td style=\"vertical-align: top; text-align: center\">"
			+ data['lagnantakaalamulu']['raasi9'] + "<br>";
	panchangamHTML += "</td>";
	panchangamHTML += "<td style=\"vertical-align: top\">"
			+ data['lagnantakaalamulu']['time9'] + "</td>";
	panchangamHTML += "</tr>";
	panchangamHTML += "<tr>";
	panchangamHTML += "<td colspan=\"1\" rowspan=\"3\"";
	panchangamHTML += "style=\"vertical-align: top; text-align: center\">9 ధనుస్సు<br>";
	if (data['raasiChakram']['dhanurGrahaSthithi'] != null) {
		panchangamHTML += data['raasiChakram']['dhanurGrahaSthithi'] + "</td>";
	} else {
		panchangamHTML += "</td>";
	}
	panchangamHTML += "<td colspan=\"1\" rowspan=\"3\"";
	panchangamHTML += "style=\"vertical-align: top; text-align: center\">8 వృశ్చికం<br>";
	if (data['raasiChakram']['vruschikamGrahaSthithi'] != null) {
		panchangamHTML += data['raasiChakram']['vruschikamGrahaSthithi']
				+ "</td>";
	} else {
		panchangamHTML += "</td>";
	}
	panchangamHTML += "<td colspan=\"1\" rowspan=\"3\"";
	panchangamHTML += "style=\"vertical-align: top; text-align: center\">7 తులా<br>";
	if (data['raasiChakram']['tulaGrahaSthithi'] != null) {
		panchangamHTML += data['raasiChakram']['tulaGrahaSthithi'] + "</td>";
	} else {
		panchangamHTML += "</td>";
	}
	panchangamHTML += "<td colspan=\"1\" rowspan=\"3\"";
	panchangamHTML += "style=\"vertical-align: top; text-align: center\">6 కన్యా<br>";
	if (data['raasiChakram']['kanyaGrahaSthithi'] != null) {
		panchangamHTML += data['raasiChakram']['kanyaGrahaSthithi'] + "</td>";
	} else {
		panchangamHTML += "</td>";
	}
	panchangamHTML += "<td style=\"vertical-align: top; text-align: center\">"
			+ data['lagnantakaalamulu']['raasi10'] + "<br>";
	panchangamHTML += "</td>";
	panchangamHTML += "<td style=\"vertical-align: top\">"
			+ data['lagnantakaalamulu']['time10'] + "</td>";
	panchangamHTML += "</tr>";
	panchangamHTML += "<tr>";
	panchangamHTML += "<td style=\"vertical-align: top; text-align: center\">"
			+ data['lagnantakaalamulu']['raasi11'] + "<br>";
	panchangamHTML += "</td>";
	panchangamHTML += "<td style=\"vertical-align: top\">"
			+ data['lagnantakaalamulu']['time11'] + "</td>";
	panchangamHTML += "</tr>";
	panchangamHTML += "<tr>";
	panchangamHTML += "<td style=\"vertical-align: top; text-align: center\">"
			+ data['lagnantakaalamulu']['raasi12'] + "<br>";
	panchangamHTML += "</td>";
	panchangamHTML += "<td style=\"vertical-align: top\">"
			+ data['lagnantakaalamulu']['time12'] + "</td>";
	panchangamHTML += "</tr>";
	panchangamHTML += "<tr>";
	panchangamHTML += "<td style=\"vertical-align: top; text-align: center\">సూర్యోదయం<br>";
	panchangamHTML += "</td>";
	panchangamHTML += "<td colspan=\"2\" rowspan=\"1\"";
	panchangamHTML += "style=\"vertical-align: top; text-align: left\">"
			+ data['day']['sunrise'] + "<br>";
	panchangamHTML += "</td>";
	panchangamHTML += "<td style=\"vertical-align: top; text-align: center\">రాహుకాలం<br>";
	panchangamHTML += "</td>";
	panchangamHTML += "<td colspan=\"2\" rowspan=\"1\"";
	panchangamHTML += "style=\"vertical-align: top; text-align: center\">"
			+ data['day']['rahukalam'] + "<br>";
	panchangamHTML += "</td>";
	panchangamHTML += "</tr>";
	panchangamHTML += "<tr>";
	panchangamHTML += "<td style=\"vertical-align: top; text-align: center\">సూర్యాస్తం<br>";
	panchangamHTML += "</td>";
	panchangamHTML += "<td colspan=\"2\" rowspan=\"1\"";
	panchangamHTML += "style=\"vertical-align: top; text-align: left\">"
			+ data['day']['sunset'] + "<br>";
	panchangamHTML += "</td>";
	panchangamHTML += "<td style=\"vertical-align: top; text-align: center\">వర్జ్యం<br>";
	panchangamHTML += "</td>";
	panchangamHTML += "<td colspan=\"2\" rowspan=\"1\"";
	panchangamHTML += "style=\"vertical-align: top; text-align: center\">";
	try {
		if (data['day']['varjyamulu'][0].varjyamStartTime != null) {
			panchangamHTML += data['day']['varjyamulu'][0].varjyamStartTime
					+ " - " + data['day']['varjyamulu'][0].varjyamEndTime
					+ "<br>";
		}
		if (data['day']['varjyamulu'][1].varjyamStartTime != null) {
			panchangamHTML += data['day']['varjyamulu'][1].varjyamStartTime
					+ " - " + data['day']['varjyamulu'][1].varjyamEndTime;
		}
	} catch (e) {

	}

	panchangamHTML += "</td>";
	panchangamHTML += "</tr>";
	panchangamHTML += "</tbody>";
	panchangamHTML += "	</table>";
	$("#panchangamViewer").html(panchangamHTML);

}
var panchangamHTML = "<table style=\"text-align: left; width: 571px; height: 669px\" border=\"1\" 	cellpadding=\"2\" cellspacing=\"2\"> 	<tbody><tr>	<td colspan=\"2\" rowspan=\"1\"		style=\"vertical-align: top; text-align: center\">ఖర నామ సంవత్సరం		2011</td>	<td colspan=\"2\" rowspan=\"1\"		style=\"vertical-align: top; text-align: center\">${day.aayanam}</td>	<td colspan=\"2\" rowspan=\"1\"		style=\"vertical-align: top; text-align: center\">ఈనాటి పర్వము</td></tr><tr>	<td colspan=\"1\" rowspan=\"2\"		style=\"vertical-align: top; text-align: center\">${day.month} ${day.date}</td>	<td style=\"vertical-align: top; text-align: center\">ఋతువు<br>	</td>	<td style=\"vertical-align: top; text-align: center\">మాసం<br>	</td>	<td style=\"vertical-align: top; text-align: center\">పక్షం<br>	</td>	<td colspan=\"2\" rowspan=\"2\"		style=\"vertical-align: top; text-align: center\"><span		style=\"font-weight: bold\">${day.visesham}</span><br>	</td></tr><tr>	<td style=\"vertical-align: top; text-align: center\">${currentTithi.rutuvu}<br>	</td>	<td style=\"vertical-align: top; text-align: center\">${currentTithi.maasam}<br>	</td>	<td style=\"vertical-align: top; text-align: center\">${currentTithi.paksham}<br>	</td></tr><tr>	<td colspan=\"4\" rowspan=\"1\"		style=\"vertical-align: top; text-align: center\"><span		style=\"font-size: 12pt; line-height: 115%; font-weight: bold\" >రాశి చక్రం - గ్రహ స్థితి</span><span style=\"font-size: 10pt; line-height: 115%; \"		> </span>	</td>	<td colspan=\"2\" rowspan=\"1\"		style=\"vertical-align: top; text-align: center\"><span		style=\"font-weight: bold\">లగ్నాంతకాలములు</span><br></td></tr><tr>	<td colspan=\"1\" rowspan=\"3\"		style=\"vertical-align: top; text-align: center\">12 మీనం <br>		రవి, చంద్ర, కుజ, <br> బుభ, గురు <br></td>	<td colspan=\"1\" rowspan=\"3\"		style=\"vertical-align: top; text-align: center\">1 మేషం<br>	</td>	<td colspan=\"1\" rowspan=\"3\"		style=\"vertical-align: top; text-align: center\">2 వృషభం<br>	</td>	<td colspan=\"1\" rowspan=\"3\"		style=\"vertical-align: top; text-align: center\">3 మిథునం<br>		కేతు</td>	<td style=\"vertical-align: top; text-align: center\">మీన<br>	</td>	<td style=\"vertical-align: top\">6:54AM<br></td></tr><tr>	<td style=\"vertical-align: top; text-align: center\">మేష<br>	</td>	<td style=\"vertical-align: top\">9:54 AM</td></tr><tr>	<td style=\"vertical-align: top; text-align: center\">వృషభ<br>	</td>	<td style=\"vertical-align: top\">11:56 AM</td></tr><tr>	<td colspan=\"1\" rowspan=\"3\"		style=\"vertical-align: top; text-align: center\">11 కుంభం<br>		శుక్ర</td>	<td colspan=\"2\" rowspan=\"1\"		style=\"vertical-align: top; text-align: center\">పంచాంగం<br>	</td>	<td colspan=\"1\" rowspan=\"3\"		style=\"vertical-align: top; text-align: center\">4 కర్కాటకం<br>	</td>	<td style=\"vertical-align: top; text-align: center\">మిథున<br>	</td>	<td style=\"vertical-align: top\">12:55PM<br></td></tr><tr>	<td colspan=\"2\" rowspan=\"5\" style=\"vertical-align: top\">• తిథి -		పాడ్యమి రా 9.06 <br> • సోమవారము <br> • నక్షత్రం - రేవతి సా		4.14 <br> • ఐంద్ర – యోగం <br> • కింస్తుఘ్న – కరణం <br>	</td>	<td style=\"vertical-align: top; text-align: center\">కర్కాటక<br>	</td>	<td style=\"vertical-align: top\">3:04PM<br></td></tr><tr>	<td style=\"vertical-align: top; text-align: center\">సింహ<br>	</td>	<td style=\"vertical-align: top\">5:07PM<br></td></tr><tr>	<td colspan=\"1\" rowspan=\"3\"		style=\"vertical-align: top; text-align: center\">10 మకరం<br>	</td>	<td colspan=\"1\" rowspan=\"3\" style=\"vertical-align: top\">5 సింహం<br>	</td>	<td style=\"vertical-align: top; text-align: center\">కన్యా<br>	</td>	<td style=\"vertical-align: top\">7:08PM<br></td></tr><tr>	<td style=\"vertical-align: top; text-align: center\">తులా<br>	</td>	<td style=\"vertical-align: top\">9:14PM<br></td></tr><tr>	<td style=\"vertical-align: top; text-align: center\">వృశ్చిక<br>	</td>	<td style=\"vertical-align: top\">11:25PM<br></td></tr><tr>	<td colspan=\"1\" rowspan=\"3\"		style=\"vertical-align: top; text-align: center\">9 ధనుస్సు<br>		రాహు</td>	<td colspan=\"1\" rowspan=\"3\"		style=\"vertical-align: top; text-align: center\">8 వృశ్చికం<br>	</td>	<td colspan=\"1\" rowspan=\"3\"		style=\"vertical-align: top; text-align: center\">7 తులా<br>	</td>	<td colspan=\"1\" rowspan=\"3\"		style=\"vertical-align: top; text-align: center\">6 కన్యా<br>		శని</td>	<td style=\"vertical-align: top; text-align: center\">ధనుర్<br>	</td>	<td style=\"vertical-align: top\">1:33AM<br></td></tr><tr>	<td style=\"vertical-align: top; text-align: center\">మకర<br>	</td>	<td style=\"vertical-align: top\">3:27AM<br></td></tr><tr>	<td style=\"vertical-align: top; text-align: center\">కుంభ<br>	</td>	<td style=\"vertical-align: top\">5:10AM<br></td></tr><tr>	<td style=\"vertical-align: top; text-align: center\">సూర్యోదయం<br>	</td>	<td colspan=\"2\" rowspan=\"1\"		style=\"vertical-align: top; text-align: left\">6:17AM<br>	</td>	<td style=\"vertical-align: top; text-align: center\">రాహుకాలం<br>	</td>	<td colspan=\"2\" rowspan=\"1\"		style=\"vertical-align: top; text-align: center\">7.30 - 9.00<br>	</td></tr><tr>	<td style=\"vertical-align: top; text-align: center\">సూర్యాస్తం<br>	</td>	<td colspan=\"2\" rowspan=\"1\"			style=\"vertical-align: top; text-align: left\">6:34PM<br>	</td>	<td style=\"vertical-align: top; text-align: center\">వర్జ్యం<br>	</td>	<td colspan=\"2\" rowspan=\"1\"		style=\"vertical-align: top; text-align: center\">వర్జ్యం లేదు<br>	</td></tr> 	</tbody> </table>";