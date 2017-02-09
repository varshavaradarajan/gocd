/*
 * Copyright 2016 ThoughtWorks, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

var Stream      = require('mithril/stream');
var _           = require('lodash');
var s           = require('string-plus');
var Mixins      = require('models/mixins/model_mixins');
var Validatable = require('models/mixins/validatable_mixin');

var Artifacts = function (data) {
  Mixins.HasMany.call(this, {factory: Artifacts.Artifact.create, as: 'Artifact', collection: data});
};

Artifacts.Artifact = function (data) {
  this.constructor.modelType = 'artifact';
  Mixins.HasUUID.call(this);
  Validatable.call(this, data);

  this.parent = Mixins.GetterSetter();

  this.type        = Stream(s.defaultToIfBlank(data.type, 'build'));
  this.source      = Stream(s.defaultToIfBlank(data.source, ''));
  this.destination = Stream(s.defaultToIfBlank(data.destination, ''));

  this.isBlank = function () {
    return s.isBlank(this.source()) && s.isBlank(this.destination());
  };

  this.validatePresenceOf('source', {
    condition: function (property) {
      return (!s.isBlank(property.destination()));
    }
  });
};

Artifacts.Artifact.create = function (data) {
  return new Artifacts.Artifact(data);
};

Mixins.fromJSONCollection({
  parentType: Artifacts,
  childType:  Artifacts.Artifact,
  via:        'addArtifact'
});

Artifacts.Artifact.fromJSON = function (data) {
  return new Artifacts.Artifact(_.pick(data, ['type', 'source', 'destination']));
};

module.exports = Artifacts;
