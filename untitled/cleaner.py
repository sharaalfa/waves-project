import re
def review_to_wordlist(review):
    review_text = re.sub("[^a-zA-Z]", " ", review)
    words = review_text.lower().split()
    return (words)