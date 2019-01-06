(ns cljfx.fx.media-view
  (:require [cljfx.lifecycle.composite :as lifecycle.composite]
            [cljfx.fx.node :as fx.node]
            [cljfx.lifecycle :as lifecycle]
            [cljfx.coerce :as coerce])
  (:import [javafx.scene.media MediaView]
           [javafx.scene.image ImageView]))

(def lifecycle
  (lifecycle.composite/describe MediaView
    :ctor []
    :extends [fx.node/lifecycle]
    :props {:media-player [:setter lifecycle/dynamic]
            :on-error [:setter lifecycle/event-handler :coerce coerce/event-handler]
            :preserve-ratio [:setter lifecycle/scalar :default true]
            :smooth [:setter lifecycle/scalar :default ImageView/SMOOTH_DEFAULT]
            :x [:setter lifecycle/scalar :coerce double :default 0.0]
            :y [:setter lifecycle/scalar :coerce double :default 0.0]
            :fit-width [:setter lifecycle/scalar :coerce double :default 0.0]
            :fit-height [:setter lifecycle/scalar :coerce double :default 0.0]
            :viewport [:setter lifecycle/scalar :coerce coerce/rectangle-2d]}))