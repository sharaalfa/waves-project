from sklearn.feature_extraction.text import CountVectorizer
from sklearn.ensemble import RandomForestClassifier
import pandas as pd
import numpy as np
data = pd.read_csv('/home/sharhack/Загрузки/waves/assets.csv')
scam = pd.read_csv('/home/sharhack/Загрузки/waves/Scam.csv')
import re
import nltk
import time
from bs4 import BeautifulSoup
from nltk.corpus import stopwords


def review_to_wordlist(review):
    review_text = re.sub("[^a-zA-Z]", " ", review)
    words = review_text.lower().split()
    return (words)


scam_list = []
for index, row in scam.iterrows():
    scam_list.append(row['2udT6qcXrYNdkwAqY8ZLGUJtL9UCno6bWsx5YoHpcnqo'])
# for row in scam:
#  scam_list = scam_list.append(row['2udT6qcXrYNdkwAqY8ZLGUJtL9UCno6bWsx5YoHpcnqo'])
data['target'] = data['assetid'].isin(scam_list)
meta = data.drop('height', 1).drop('v', 1).drop('qqq', 1).drop('www', 1).drop('eee', 1).drop('eer', 1).drop('dds',
                                                                                                            1).drop(
    'ttt', 1).drop('ddcc', 1).drop('jjj', 1).drop('yyy', 1)
meta = meta.dropna()
from sklearn.model_selection import train_test_split

(X_train, X_test, y_train, y_test) = train_test_split(meta['description'], meta['target'], test_size=0.3,
                                                      random_state=0)
clean_train_reviews = []
for row in X_train:
    clean_train_reviews.append(" ".join(review_to_wordlist(row)))

vectorizer = CountVectorizer(analyzer="word", tokenizer=None, preprocessor=None, stop_words=None, max_features=5000)
train_data_features = vectorizer.fit_transform(clean_train_reviews)
np.asarray(train_data_features)
forest = RandomForestClassifier(n_estimators=100)
forest = forest.fit(train_data_features, y_train)
clean_test_reviews = []
for row in X_test:
    clean_test_reviews.append(" ".join(review_to_wordlist(row)))
test_data_features = vectorizer.transform(clean_test_reviews)
np.asarray(test_data_features)
result = forest.predict(test_data_features)


def predictation(description):
    test_data_features = vectorizer.transform([description])
    result = forest.predict(test_data_features)
    return result


print(predictation('Everyone will get 1000 waves'))





