(ns flexiana.scrambler-test
  (:use [clojure.test :only [deftest is]]
        [flexiana.scrambler :only [scrambled? replacer]]))

(deftest scrambled-is-working
  (is (= (scrambled? "rekqodlw" "world") true))
  (is (= (scrambled? "cedewaraaossoqqyt" "codewars") true))
  (is (= (scrambled? "katas" "steak") false))
  (is (= (scrambled? nil "steak") false))
  (is (= (scrambled? "katas" nil) true))
  (is (= (scrambled? nil nil) true))
  (is (= (scrambled? "katas" "skata") true))
  (is (= (scrambled? "katas" "katas") true))
  (is (= (scrambled? "katas" "katasa") false)))

(deftest replacer-is-working
  (is (= (replacer nil "he") '(nil "he")))
  (is (= (replacer nil nil) '(nil nil)))
  (is (= (replacer "llo" nil) '("llo" nil)))
  (is (= (replacer "llo" '()) '("llo" ())))
  (is (= (replacer "hello" "he") '("llo" ())))
  (is (= (replacer "ello" '(\e)) '("llo" ()))))
