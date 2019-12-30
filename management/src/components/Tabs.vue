<template>
    <div>
        <b-tabs content-class="mt-3" fill>
            <b-tab title="Arbitrages" active><Arbitrages /></b-tab>
            <b-tab title="Games"><Games /></b-tab>
            <b-tab title="Bet Calculator"><BetCalculator /></b-tab>
        </b-tabs>
    </div>
</template>

<script>
  import Arbitrages from './tabs/Arbitrages.vue'
  import Games from './tabs/Games.vue'
  import BetCalculator from './tabs/BetCalculator.vue'

  export default {
    components: {
      Arbitrages,
      Games,
      BetCalculator
    }
  }
</script>