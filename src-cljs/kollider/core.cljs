(ns kollider.core
  (:require [reagent.core :as r]))

(enable-console-print!)

(defn hello-world []
  [:h1 "Hello world!"])

(defn start []
  (r/render-component
    [hello-world]
    (.getElementById js/document "root")))
