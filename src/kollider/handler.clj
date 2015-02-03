(ns kollider.handler
  (:require [compojure.core :refer [defroutes GET POST]]
            [compojure.route :as route]
            [ring.middleware.defaults :refer [wrap-defaults site-defaults]]
            [hiccup.page :refer [html5 include-css]]
            [clojure.pprint :refer [pprint]])
  (:use [ring.middleware.anti-forgery]
        [ring.middleware.session]
        [ring.util.anti-forgery]))

(def board-fp (atom [["Hello" "OMG" "yo"] ["fun" "asdfasdf" "asa"]]))
(def board-brace (atom [["write less JS" "nothx" "ok"] ["IDK" "what is this" "asdf"] ["pointless" "yea"]]))

(defn as-ul [v]
  [:ul (map (fn [item] [:li (str item)]) v)])

(defn content-to-ul [c]
  [:ul (map (fn [item] [:li (str (first item)) (as-ul (rest item))]) c)])

(defn common [& body]
  (html5
   [:head
    [:title "Kollider"]
    (include-css "/css/screen.css")]
   [:body body]))

(defn form-post [route]
  [:form
   {:method "post" :action "/new"}
   [:input {:type "text" :name "msg"}]
   [:input {:type "submit" :value "Submit"}]
   (anti-forgery-field)])

(defn home [& flash]
  (common
   [:h1 "Kollider"]
   [:p flash]
   [:p [:ul
        [:li
         "Functional Programming"
         (content-to-ul @board-fp)
         (form-post "/fp")
         [:li "Curly brace langs" (content-to-ul @board-brace)]]]]))

(defn new-post [message]
  (println message)
  (home (str "Message `" message "` received!")))

(defroutes app-routes
  (GET "/" [] (home))
  (POST "/new" [msg] (new-post msg))
  (route/resources "/")
  (route/not-found "Not Found"))

(def app
  (wrap-defaults (wrap-anti-forgery app-routes) site-defaults))
