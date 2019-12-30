from typing import Iterable, Tuple, TypeVar
from bs4 import BeautifulSoup
from .game import Game, GameEncoder
import requests
import json

T = TypeVar("T")
url = "https://1xbet.com/en/line/American-Football/68315-USA-NFL/"
BOOKMAKER = '1Xbet'


def grouped(iterable: Iterable[T], n=2) -> Iterable[Tuple[T, ...]]:
    return zip(*[iter(iterable)] * n)


def get_data():
    soup = BeautifulSoup(requests.get(url, verify=False).text, 'html.parser')
    data = [[game.contents[1].contents[5].text, game.contents[3].text] for game in
            soup.findAll('div', class_='c-events__item c-events__item_game')]

    games = []
    for game in data:
        teams = game[0].strip().split('\n')
        coefficients = game[1].strip().split('\n')
        if teams[0].strip() in games or teams[1].strip() in games:
            continue
        if coefficients[0].strip() != '-':
            first_team, first_team_coefficient = teams[0].strip(), coefficients[0].strip()
            second_team, second_team_coefficient = teams[1].strip(), coefficients[4].strip()
            games.append(Game(first_team, second_team, first_team_coefficient, second_team_coefficient, BOOKMAKER))

    return json.dumps(games, cls=GameEncoder)
