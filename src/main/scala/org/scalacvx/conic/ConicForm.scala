package org.scalacvx.conic

import org.scalacvx.atoms.Expression
import org.scalacvx.constraints.Constraint
import org.scalacvx.structures.SparseMatrix

/**
 * Conic Form (i.e. graph form of a convex optimization problem)
 *
 *    minimize    c'x
 *    subject to  Ax = b
 *                x in K
 *    (K being a convex cone - zero, free, positive orthant, second order, semidefinite, exponential)
 *
 *
 */
case class ConicForm(objective: Expression, constraints:Array[Constraint]) {



  /*
  def unary_- = ConicForm(m map {case (i,sp) => (-1*i,sp)})

  def +(that:ConicForm):ConicForm = ???

  def getRow(row:Int) = ConicForm(m filter {case (i,sp) => i == row})

  def *(v:SparseMatrix) = ConicForm(m map {case (i, sp) => (i, sp * v)}) // * to be defined in SparseMatrix

  def promoteSize(vectorized_size:Int) = ???
  */
}

/*
case class ConicConstr(objs:Array[ConicForm], sizes:Array[Int])

object ConicForm {
  type UniqueExpMap = Map[(Int,Int), ConicForm] // Note: (Int,Int) is in fact (Symbol,Int) in Convex.jl
  type UniqueConstrMap = Map[(Int,Int), Int]
  type UniqueConstrList = Array[ConicConstr]
}

case class UniqueConicForms(exp_map:UniqueExpMap, constr_map:UniqueConstrMap, constr_list:UniqueConstrList)
*/