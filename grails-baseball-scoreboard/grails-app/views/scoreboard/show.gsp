<%--
  Created by IntelliJ IDEA.
  User: MPMENN
  Date: 10/2/11
  Time: 1:08 PM
  To change this template use File | Settings | File Templates.
--%>

<%@ page import="com.github.grailsbaseballscoreboard.Game" contentType="text/html;charset=UTF-8" %>


<html>
  <head><title>${homeTeam.toString()} vs. ${awayTeam.toString()}</title></head>
  <body>
    <h2>Scoreboard brought to you by Budweiser</h2>

    <table>
        <tr>
            <div name="innings">
                <td></td>
                <td name="inning1-label">--1--</td>
                <td name="inning2-label">--2--</td>
                <td name="inning3-label">--3--</td>
                <td name="inning4-label">--4--</td>
                <td name="inning5-label">--5--</td>
                <td name="inning6-label">--6--</td>
                <td name="inning7-label">--7--</td>
                <td name="inning8-label">--8--</td>
                <td name="inning9-label">--9--</td>
                <td name="runs-label">--R--</td>
                <td name="hits-label">--H--</td>
                <td name="errors-label">--E--</td>
            </div>
        </tr>
        <tr>
            <div name="top">
                <td>
                    <h3>${awayTeam}</h3>
                </td>
                %{--<td name="inning1-away">${Game.all.get(0).innings.get(0).runsByAwayTeam}</td>--}%
                %{--<td name="inning2-away">${Game?.all?.get(0)?.innings?.get(0)?.runsByAwayTeam}</td>--}%
                %{--<td name="inning3-away">${Game.all.get(0).innings.get(2).runsByAwayTeam}</td>--}%
                %{--<td name="inning4-away">${Game.all.get(0).innings.get(3).runsByAwayTeam}</td>--}%
                %{--<td name="inning5-away">${Game.all.get(0).innings.get(4).runsByAwayTeam}</td>--}%
                %{--<td name="inning6-away">${Game.all.get(0).innings.get(5).runsByAwayTeam}</td>--}%
                %{--<td name="inning7-away">${Game.all.get(0).innings.get(6).runsByAwayTeam}</td>--}%
                %{--<td name="inning8-away">${Game.all.get(0).innings.get(7).runsByAwayTeam}</td>--}%
                %{--<td name="inning9-away">${Game.all.get(0).innings.get(8).runsByAwayTeam}</td>--}%
            </div>
        </tr>
        <tr>
            <div name="bottom">
                <td>
                    <h3>${homeTeam}</h3>
                </td>
                %{--<td name="inning1-home">${Game.all.get(0).innings.get(0).runsByAwayTeam}</td>--}%
                %{--<td name="inning2-home">${Game?.list()?.get(0)?.innings?.get(0)?.runsByHomeTeam}</td>--}%
                %{--<td name="inning3-home">${Game.all.get(0).innings.get(2).runsByAwayTeam}</td>--}%
                %{--<td name="inning4-home">${Game.all.get(0).innings.get(3).runsByAwayTeam}</td>--}%
                %{--<td name="inning5-home">${Game.all.get(0).innings.get(4).runsByAwayTeam}</td>--}%
                %{--<td name="inning6-home">${Game.all.get(0).innings.get(5).runsByAwayTeam}</td>--}%
                %{--<td name="inning7-home">${Game.all.get(0).innings.get(6).runsByAwayTeam}</td>--}%
                %{--<td name="inning8-home">${Game.all.get(0).innings.get(7).runsByAwayTeam}</td>--}%
                %{--<td name="inning9-home">${Game.all.get(0).innings.get(8).runsByAwayTeam}</td>--}%
            </div>
        </tr>
    </table>
  </body>
</html>