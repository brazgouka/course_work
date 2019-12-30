<template>
<div>
    <br/><b-button pill @click="sync" variant="primary">Refresh</b-button><br/><br/><br/><br/>
    <CalculateBet :selected="selected"></CalculateBet>
</div>
</template>

<script>
  import CalculateBet from './CalculateBet.vue'

  export default {
    components: {
      CalculateBet
    },

    methods: {
      sync() {
                fetch('http://localhost:8081/', {
                    method: 'get'
                })
            },
            reloadArbitages() {
                fetch('http://localhost:8081/best-arbitrage', {
                    method: 'get'
                }).then(response => {
                    return response.json()
                }).then(jsonData => {
                    this.selected = jsonData
                })
            }
        },

    data() {
            return {
                selected: []
            }
        },

    mounted: function() {
            this.reloadArbitages();
        }
  }
</script>