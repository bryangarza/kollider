(ns kollider.core
  (:require [reagent.core :as reagent :refer [atom]]
            [secretary.core :as secretary :refer-macros [defroute]]
            [kollider.pages.home :refer [home-page]]))

(enable-console-print!)

(defroute "/" []
  (home-page))

(defn header []
  [:div.header [:h1 "Kollider"]])

(defn page []
  [header]
  (home-page))

(defn init! []
  (reagent/render-component
    [page]
    (.getElementById js/document "app")))

(init!)
