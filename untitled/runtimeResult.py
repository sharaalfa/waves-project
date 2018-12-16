import urllib, json, requests
from sklearn.feature_extraction.text import CountVectorizer
from sklearn.ensemble import RandomForestClassifier
import numpy as np
from joblib import load
import cleaner
from flask import Flask
from flask_cors import CORS

url = 'http://127.0.0.1:5000'
clean_test_reviews = []
forest = load('/home/sharhack/Загрузки/waves/forest.joblib')
X_test = load('/home/sharhack/Загрузки/waves/X_test.joblib')
vectorizer = load('/home/sharhack/Загрузки/waves/vectorizer.joblib')
clean_train_reviews = []
for row in X_test:
    clean_test_reviews.append(" ".join(cleaner.review_to_wordlist(row)))
test_data_features = vectorizer.transform(clean_test_reviews)
np.asarray(test_data_features)
result = forest.predict(test_data_features)
def predictation(i_description):
    description=i_description
    test_data_features = vectorizer.transform([description])
    result = forest.predict(test_data_features)
    return result

app = Flask(__name__)
cors = CORS(app, resources={r"/api/*": {"origins": "*"}})
@app.route('/<i_description>')
def reload(i_description):
    description = i_description
    st = predictation(description)
    return str(st)
