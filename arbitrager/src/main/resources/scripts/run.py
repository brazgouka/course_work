from flask import Flask
from flask import jsonify
from scr import xbet_parser
from scr import marathon_parser


app = Flask(__name__)


@app.route('/parse-xbet')
def parse_xbet():
    return xbet_parser.get_data()


@app.route('/parse-marathon')
def parse_marathon():
    return marathon_parser.get_data()


if __name__ == '__main__':
    app.run()
