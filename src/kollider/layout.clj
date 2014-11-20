(ns kollider.layout
  (:require [throttler.core :refer [throttle-chan throttle-fn]]
            [selmer.parser :as parser]
            [ring.util.response :refer [content-type response]]
            [compojure.response :refer [Renderable]]
            [environ.core :refer [env]]))

(def template-path "templates/")

(deftype RenderableTemplate [template params]
  Renderable
  (render [this request]
    (content-type
      (->> (assoc params
                  :dev (env :dev))
           (parser/render-file (str template-path template))
           response)
      "text/html; charset=utf-8")))

(defn render-fn [template & [params]]
  (RenderableTemplate. template params))

(def render (throttle-fn render-fn 50 :second))
