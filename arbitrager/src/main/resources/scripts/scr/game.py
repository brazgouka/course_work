import json


class Game:

    def __init__(self, first_team, second_team, first_team_coefficient, second_team_coefficient, bookmaker):
        self.first_team = first_team
        self.second_team = second_team
        self.first_team_coefficient = first_team_coefficient
        self.second_team_coefficient = second_team_coefficient
        self.bookmaker = bookmaker


class GameEncoder(json.JSONEncoder):
    def default(self, obj):
        if isinstance(obj, Game):
            return {
                'firstTeam': obj.first_team,
                'secondTeam': obj.second_team,
                'firstTeamCoefficient': obj.first_team_coefficient,
                'secondTeamCoefficient': obj.second_team_coefficient,
                'bookmaker': obj.bookmaker
            }
        return json.JSONEncoder.default(self, obj)
