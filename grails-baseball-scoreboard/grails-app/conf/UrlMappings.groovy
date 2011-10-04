class UrlMappings {

	static mappings = {
        "/scoreboard/$homeTeam/$awayTeam"(controller:'scoreboard', action:'show', params:"[homeTeamName:$homeTeam, awayTeamName:$awayTeam]") {

        }

		"/$controller/$action?/$id?"{
			constraints {
				// apply constraints here
			}
		}

		"/"(view:"/index")
		"500"(view:'/error')
	}
}
