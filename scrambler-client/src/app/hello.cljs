(ns app.hello
  (:require-macros [cljs.core.async.macros :refer [go]])
  (:require [reagent.core :as r]
            [cljs-http.client :as http]
            [cljs.core.async :refer [<!]]))

(defn scrambled-string-input [scrambled-string]
  (fn []
    [:input
     {:value        @scrambled-string
      :type         "text"
      :placeholder  "Scrambled String"
      :on-change    #(reset! scrambled-string (.. % -target -value))}]))


(defn word-input [word]
  (fn []
    [:input
     {:value        @word
      :type         "text"
      :placeholder  "Word"
      :on-change    #(reset! word (.. % -target -value))}]))


(defn scrambler []
  (let [scrambled-string (r/atom "") word (r/atom "")]

    (fn []
      [:div
       [:p "Can it scramble?:"]
       [scrambled-string-input scrambled-string]
       [word-input word]
       [:input {:type "button" :value "Let's Scramble!"
                :on-click #(go (let [response (<! (http/get "http://localhost:1337/scrambler"
                                                            {:with-credentials? false
                                                             :query-params {"scrambled-string"  @scrambled-string "word" @word}}))]
                                 (js/alert (get (get response :body) :result))))}]])))

(defn hello []
  [:<>
   [:p "Hello, this is an app, testing whether if by anagraming a string (or a subset of it) a given word can be generated"]
   [scrambler]])
