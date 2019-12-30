from bs4 import BeautifulSoup
import requests
import json
from typing import Iterable, Tuple, TypeVar
from .game import Game, GameEncoder

T = TypeVar("T")
url = "https://www.marathonbet.com/en/betting/American+Football/NFL/"
BOOKMAKER = 'Marathon'


def grouped(iterable: Iterable[T], n=2) -> Iterable[Tuple[T, ...]]:
    return zip(*[iter(iterable)] * n)


def get_data():
    soup = BeautifulSoup(requests.get(url, verify=False).text, 'html.parser')

    team_coefficients = [{state.text.strip(): link.text} for state, link in
                         zip(soup.findAll('div', class_='member-name'),
                             soup.findAll('span', class_='selection-link'))]

    games = []
    for game in grouped(team_coefficients, 2):
        first = list(game[0].items())[0]
        second = list(game[1].items())[0]
        first_team, first_team_coefficient = first[0], first[1]
        second_team, second_team_coefficient = second[0], second[1]
        games.append(Game(first_team, second_team, first_team_coefficient, second_team_coefficient, BOOKMAKER))

    return json.dumps(games, cls=GameEncoder)
